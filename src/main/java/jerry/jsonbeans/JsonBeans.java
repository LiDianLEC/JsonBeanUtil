package jerry.jsonbeans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jerry.jsonbeans.models.ClassDescribe;
import jerry.jsonbeans.models.FieldDescribe;
import jerry.jsonbeans.utils.FileUtils;
import jerry.jsonbeans.utils.StringUtils;

import java.io.*;
import java.util.*;

/**
 * @author Jerry Ou
 * @version 1.0 2016-05-03 13:55
 * @since JDK 1.6
 */
public class JsonBeans {

    private static Config config = Config.me();

    public static Map<String, String> primitiveWrappers = new HashMap<String, String>() {
        private static final long serialVersionUID = 8015328537607906480L;

        {
            put("Byte", "byte");
            put("Short", "short");
            put("Integer", "int");
            put("Long", "long");

            put("Boolean", "boolean");

            put("Float", "float");
            put("Double", "double");

            put("Character", "char");
        }
    };

    public static void json2bean(String json, ClassDescribe classInfo) {
        JSONObject jsonObject = JSON.parseObject(json);
        json2bean(jsonObject, classInfo);
        genFiles(classInfo);
    }

    private static void json2bean(JSONObject jsonObject, ClassDescribe describe) {
        Set<String> keySet = jsonObject.keySet();
        List<FieldDescribe> fieldDescribes = new ArrayList<FieldDescribe>(keySet.size());
        List<ClassDescribe> classDescribes = new ArrayList<ClassDescribe>();
        describe.fieldDescribes = fieldDescribes;
        describe.classDescribes = classDescribes;

        Set<String> importSet = new HashSet<String>();

        for (String name : keySet) {
            Object object = jsonObject.get(name);
            String type = "String";
            String importype = "";
            if (object != null) {
                type = object.getClass().getName();
                if (type.equals("com.alibaba.fastjson.JSONObject")) { //是一个 Object
                    type = StringUtils.firstCharToUpperCase(name);
                    ClassDescribe classDescribe = new ClassDescribe(describe.packageName, type);
                    classDescribes.add(classDescribe);
                    json2bean((JSONObject) object, classDescribe);
                }  else if (type.equals("com.alibaba.fastjson.JSONArray")) { //是一个 JSONArray
                    importype = "java.util.List";
                    ClassDescribe classDescribe = new ClassDescribe(describe.packageName,
                            StringUtils.firstCharToUpperCase(name));
                    type = "List<"+classDescribe.className+">";
                    classDescribes.add(classDescribe);
                    json2bean(((JSONArray)object).getJSONObject(0), classDescribe);
                } else {
                    if (type.startsWith("java.lang.")) {
                        type = type.replace("java.lang.", "");
                    } else {
                        if (!importSet.contains(type)) {
                            importype = type;
                            importSet.add(importype);
                        }
                        type = type.substring(type.lastIndexOf(".")+1, type.length());
                    }
                }
            }
            if (config.getBoolean(Const.DEFAULT_LONG)) {
                if ("Integer".equals(type)) {
                    type = "Long";
                }
                if ("int".equals(type)) {
                    type = "int";
                }
            }
            if (config.getBoolean(Const.DEFAULT_DOUBLE)) {
                if ("Float".equals(type)){
                    type = "Double";
                }
                if ("float".equals(type)) {
                    type = "double";
                }
            }

            if (config.getBoolean(Const.USE_PRIMITIVE)) {
                String primitive = primitiveWrappers.get(type);
                if (primitive != null) {
                    type = primitive;
                }
            }
            FieldDescribe fieldDescribe = new FieldDescribe();
            fieldDescribe.name = name;
            fieldDescribe.importype = importype;
            fieldDescribe.type = type;

            fieldDescribes.add(fieldDescribe);
        }
    }

    private static void genFiles(ClassDescribe describe) {
        String packageName = describe.packageName;
        StringBuilder sb = new StringBuilder();

        StringBuilder packagePart = new StringBuilder();
        packagePart.append("package " + packageName + ";");
        sb.append(packagePart).append(Const._R_N);

        StringBuilder importPart = new StringBuilder();
        importPart.append("import java.io.Serializable;").append(Const._R_N);

        StringBuilder classBeginPart = new StringBuilder();
        classBeginPart.append(Const._R_N).append("//Json2Bean 自动生成")
                .append(Const._R_N).append("public class ").append(describe.className).append(" implements Serializable {")
                .append(Const._R_N).append(Const._SPACE).append("private static final long serialVersionUID = 1L;").append(Const._R_N);

        StringBuilder fieldsPart = new StringBuilder();
        StringBuilder methodsPart = new StringBuilder();

        StringBuilder classEndPart = new StringBuilder();
        classEndPart.append(Const._R_N).append("}");

        List<FieldDescribe> fieldDescribes = describe.fieldDescribes;
        if (fieldDescribes != null) {
            for (FieldDescribe fieldDescribe : fieldDescribes) {
                if (!StringUtils.isNullOrEmpty(fieldDescribe.importype)) {
                    importPart.append("import ").append(fieldDescribe.importype).append(";").append(Const._R_N);
                }
                fieldsPart.append(Const._R_N).append(Const._SPACE).append("private ").append(fieldDescribe.type).append(" ").append(fieldDescribe.name).append(";");

                methodsPart.append(Const._R_N).append(Const._SPACE).append("public void ").append("set").append(StringUtils.firstCharToUpperCase(fieldDescribe.name)).append("(")
                        .append(fieldDescribe.type).append(" ").append(fieldDescribe.name).append(") {")
                        .append(Const._R_N).append(Const._SPACE).append(Const._SPACE).append("this.").append(fieldDescribe.name).append(" = ").append(fieldDescribe.name).append(";")
                        .append(Const._R_N).append(Const._SPACE).append("}").append(Const._R_N).append(Const._R_N)
                        .append(Const._SPACE).append("public ").append(fieldDescribe.type).append(" get").append(StringUtils.firstCharToUpperCase(fieldDescribe.name)).append("() {")
                        .append(Const._R_N).append(Const._SPACE).append(Const._SPACE).append("return ").append(fieldDescribe.name).append(";")
                        .append(Const._R_N).append(Const._SPACE).append("}").append(Const._R_N);
            }
        }

        sb.append(Const._R_N).append(importPart).append(Const._R_N).append(classBeginPart).append(fieldsPart).append(Const._R_N).append(methodsPart).append(classEndPart);

        genFile(sb.toString(), describe);

        List<ClassDescribe> classDescribes = describe.classDescribes;
        if (classDescribes != null) {
            for (ClassDescribe cd : classDescribes) {
                genFiles(cd);
            }
        }

    }

    private static void genFile(String s, ClassDescribe describe) {
        File file = new File("output/" + describe.packageName.replaceAll("[.]", "/"), describe.className + ".java");
        System.out.println(file.getAbsolutePath());

        FileUtils.write(s, file);
    }
}
