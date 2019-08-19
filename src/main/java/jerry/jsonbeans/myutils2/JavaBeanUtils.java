package jerry.jsonbeans.myutils2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import jerry.jsonbeans.myutils2.models.ClassDesc;
import jerry.jsonbeans.myutils2.models.Const;
import jerry.jsonbeans.myutils2.models.DataDesc;
import jerry.jsonbeans.myutils2.models.FieldDesc;
import jerry.jsonbeans.myutils2.models.JsonDesc;
import jerry.jsonbeans.myutils2.models.PageInfo;

public class JavaBeanUtils {
	/**
{
	"message": "",
	"subCode": 0,
	"data": [{
		"protocolId": 1,
		"pageId": 1,
		"appid": "test",
		"version": "1.0.1",
		"pageName": "778",
		"pageType": "主页",
		"operation": "getUserInfo",
		"request": {
			"openId": {
				"_type": "string",
				"optional": false,
				"defaultValue": null,
				"note": "用户标识"
			},
			"name": {
				"_type": "string",
				"optional": false,
				"defaultValue": null,
				"note": "用户名称"
			},
			"age": {
				"_type": "integer",
				"optional": false,
				"defaultValue": null,
				"note": "年龄"
			}
		},
		"response": {
			"pageSize": {
				"_type": "integer",
				"optional": true,
				"defaultValue": 10,
				"note": "每页条数"
			},
			"page": {
				"_type": "integer",
				"optional": true,
				"defaultValue": 0,
				"note": "当前页码"
			},
			"total": {
				"_type": "integer",
				"optional": true,
				"defaultValue": null,
				"note": "总数"
			},
			"content": {
				"_type": "list",
				"optional": false,
				"inner": {
					"openId": {
						"_type": "string",
						"optional": false,
						"defaultValue": null,
						"note": "用户标识"
					},
					"name": {
						"_type": "string",
						"optional": false,
						"defaultValue": null,
						"note": "用户名称"
					},
					"age": {
						"_type": "integer",
						"optional": false,
						"defaultValue": null,
						"note": "年龄"
					},
					"sex": {
						"_type": "integer",
						"optional": false,
						"defaultValue": 0,
						"note": "性别0-男，1-女"
					},
					"location": {
						"_type": "string",
						"optional": false,
						"defaultValue": "中国",
						"note": "位置信息"
					}
				},
				"defaultValue": [],
				"note": "信息详情"
			}
		},
		"target": null,
		"status": "Update"
	}],
	"pageInfo": {
		"page": 0,
		"size": 10,
		"total": 1,
		"numberOfElements": 1
	}
} */
	public static void genFile(String jsonString) {
		JsonDesc jsonDesc = new JsonDesc();
		// toJsonDesc
		toJsonDesc(jsonString, jsonDesc);
		// toFile
		toFile(jsonDesc);
	}
	

	private static void toFile(JsonDesc jsonDesc) {
		// TODO Auto-generated method stub
		// define service 
		toServiceFile(jsonDesc);
		//define javabean
		toJavaBeanFile(jsonDesc);

	}


	private static void toJavaBeanFile(JsonDesc jsonDesc) {
		// TODO Auto-generated method stub
		List<DataDesc> dataDescList = jsonDesc.getDataDescList();
		for (DataDesc dataDesc : dataDescList) {
			
			List<ClassDesc> dataClassDescList = dataDesc.getClassDescList();
			for (ClassDesc classDesc : dataClassDescList) {
				toDeapJavaBeanFile(classDesc);
			}
			
		}
	}


	private static void toDeapJavaBeanFile(ClassDesc classDesc) {
		StringBuffer classSB = new StringBuffer();
		StringBuffer classPackagePart = new StringBuffer();
		StringBuffer classImportPart = new StringBuffer();
		StringBuffer classPropPart = new StringBuffer();
		StringBuffer classEndPart = new StringBuffer();
		StringBuffer classStartPart = new StringBuffer();
		
		classPackagePart.append("package packageName;").append(Const._R_N);
		classImportPart.append("import lombok.Data;").append(Const._R_N)
						.append("import io.swagger.annotations.ApiModelProperty;").append(Const._R_N)
						.append("import java.io.Serializable;").append(Const._R_N);
		List<FieldDesc> fieldDescList = classDesc.getFieldDescList();
		for (FieldDesc fieldDesc : fieldDescList) {
			if (Optional.ofNullable(fieldDesc.getImportType()).isPresent() ) {
				classImportPart.append(fieldDesc.getImportType()).append(Const._R_N);
			}
			classPropPart.append(Const._SPACE).append("@ApiModelProperty(value = \"").append(fieldDesc.getNote()).append("\"");
			if (Optional.ofNullable(fieldDesc.getFormat()).isPresent() ) {
				classPropPart.append(" format='").append(fieldDesc.getFormat()).append("'");
			}
			classPropPart.append(")").append(Const._R_N);
			
			String fieldType = fieldDesc.getFieldType();
			if ("String".equals(fieldType) || "Integer".equals(fieldType) || "Long".equals(fieldType) || "Double".equals(fieldType) || "Float".equals(fieldType) ) {
				classPropPart.append(Const._SPACE).append("@NotNull(message = \"").append(fieldDesc.getNote()).append("不能为空\")").append(Const._R_N);
			}else if (fieldType.contains("List")) {
				classPropPart.append(Const._SPACE).append("@NotEntity(message = \"").append(fieldDesc.getNote()).append("不能为空\")").append(Const._R_N);
			}else if ("Timestamp".equals(fieldType) || "Data".equals(fieldType)) {
				//TODO
				classPropPart.append(Const._SPACE).append("@NotBlank(message = \"").append(fieldDesc.getNote()).append("不能为空\")").append(Const._R_N);
			}
			classPropPart.append(Const._SPACE).append("private ").append(fieldDesc.getFieldType()).append(" ").append(fieldDesc.getFieldName());
			if (Optional.ofNullable(fieldDesc.getDefaultValue()).isPresent()) {
				if ("String".equals(fieldType)) {
					classPropPart.append(" = \"").append(fieldDesc.getDefaultValue()).append("\"");
				}else if ("Timestamp".equals(fieldType)) {
					classPropPart.append("=").append("new Timestamp(").append(fieldDesc.getDefaultValue()).append(")");
				}else if ("Data".equals(fieldType)) {
					classPropPart.append("=").append("new Data(").append(fieldDesc.getDefaultValue()).append(")");
				}else if (fieldType.contains("List")) {//"List".equals(fieldType)
					classPropPart.append("=").append("JSON.parseArray(\"").append(fieldDesc.getDefaultValue()).append("\", ArrayList.class)");
				}else if ("Map".equals(fieldType)) {
					classPropPart.append("=").append("JSON.parseObject(\"").append(fieldDesc.getDefaultValue()).append("\", HashMap.class)");
				}else {
					classPropPart.append(" = ").append(fieldDesc.getDefaultValue());
				}
			}
			classPropPart.append(";").append(Const._R_N);

		}
		classStartPart.append("@Data").append(Const._R_N)
						.append("public class ").append(classDesc.getClassName()).append(" implements Serializable {").append(Const._R_N)
						.append("private static final long serialVersionUID = 1L;").append(Const._R_N);
		classEndPart.append("}");
		
		classSB.append(classPackagePart).append(classImportPart).append(classStartPart).append(classPropPart).append(classEndPart);
		System.out.println(classSB);
		genFile(classSB,classDesc);
		List<ClassDesc> classDescList = classDesc.getClassDescList();
		if (Optional.ofNullable(classDescList).isPresent() ) {
			for (ClassDesc classDesc2 : classDescList) {
				toDeapJavaBeanFile(classDesc2);
			}
		}
	}


	private static void genFile(StringBuffer str, ClassDesc classDesc) {
		// TODO Auto-generated method stub
//		File file = new File("output/" + classDesc.getClassName(), classDesc.getClassName() + ".java");
		File file = new File("output/" , classDesc.getClassName() + ".java");
        System.out.println(file.getAbsolutePath());
		write(str.toString(), file);
	}


	private static void toServiceFile(JsonDesc jsonDesc) {
		StringBuffer serviceSB = new StringBuffer();
		StringBuffer servicePackagePart = new StringBuffer();
		servicePackagePart.append("package packageName;").append(Const._R_N);
		
		StringBuffer serviceImportPart = new StringBuffer();
		StringBuffer serviceMethodPart = new StringBuffer();
		StringBuffer serviceEndPart = new StringBuffer();
		
		StringBuffer serviceStartPart = new StringBuffer();
		serviceStartPart.append("@Service"+Const._R_N)
						.append("public interface serviceName {").append(Const._R_N);
		
		serviceEndPart.append("}");

		List<DataDesc> dataDescList = jsonDesc.getDataDescList();
		for (DataDesc dataDesc : dataDescList) {

//			serviceImportPart.append("import ").append(dataDesc.getClassDescList().get(0).getPackeName()).append(".").append(dataDesc.getClassDescList().get(0).getClassName()).append(";").append(Const._R_N)
//								.append("import ").append(dataDesc.getClassDescList().get(1).getPackeName()).append(".").append(dataDesc.getClassDescList().get(1).getClassName()).append(";").append(Const._R_N);
			serviceImportPart.append("import ").append(dataDesc.getClassDescList().get(0).getClassName()).append(";").append(Const._R_N)
			.append("import ").append(dataDesc.getClassDescList().get(1).getClassName()).append(";").append(Const._R_N);

			serviceMethodPart.append(Const._SPACE).append(dataDesc.getClassDescList().get(1).getClassName()).append(" ").append(dataDesc.getOperation()).append("(").append(dataDesc.getClassDescList().get(0).getClassName()).append(" ").append(firstCharToLowerCase(dataDesc.getClassDescList().get(0).getClassName())).append(");").append(Const._R_N);

		}
		serviceSB.append(servicePackagePart).append(serviceImportPart).append(serviceStartPart).append(serviceMethodPart).append(serviceEndPart);
		System.out.println(serviceSB);
		genFile(serviceSB,jsonDesc);
	}


	private static void genFile(StringBuffer str, JsonDesc jsonDesc) {
		// TODO Auto-generated method stub
		File file = new File("output" , "service.java");
        System.out.println(file.getAbsolutePath());
		write(str.toString(), file);
	}


	private static <E> void toJsonDesc(String jsonString, JsonDesc jsonDesc) {
		JSONObject jsonObject = JSON.parseObject(jsonString);
		Set<String> keySet = jsonObject.keySet();
		for (String key : keySet) {
			if ("message".equals(key)) {
				jsonDesc.setMessage(jsonObject.getString(key));
			}else if ("subCode".equals(key)) {
				jsonDesc.setSubCode(jsonObject.getInteger(key));
			}else if ("pageInfo".equals(key)) {
				jsonDesc.setPageInfo(jsonObject.getObject(key, PageInfo.class));
			}else if ("data".equals(key)) {
				List<DataDesc> dataDescList = new ArrayList();
				
				JSONArray jsonArray = jsonObject.getJSONArray(key);
				for (int i = 0; i < jsonArray.size(); i++) {
					DataDesc dataDesc = new DataDesc();
					// toDataDesc
					toDataDesc(jsonArray, i, dataDesc);
					dataDescList.add(dataDesc);
				}
				
				jsonDesc.setDataDescList(dataDescList);
			}else {
				throw new RuntimeException("传入参数错误");
			}
		}
		
		System.out.println("结束了");
		
		
	}

	private static void toDataDesc(JSONArray jsonArray, int i, DataDesc dataDesc) {
		JSONObject jsonObject2 = jsonArray.getJSONObject(i);
		List<ClassDesc> dataClassDescList = new ArrayList();
		Set<String> keySet2 = jsonObject2.keySet();
		for (String key2 : keySet2) {
			if ("protocolId".equals(key2)) {
				dataDesc.setProtocolId(jsonObject2.getObject(key2, Integer.class));
			}else if ("pageId".equals(key2)) {
				dataDesc.setPageId(jsonObject2.getObject(key2, Integer.class));
			}else if ("appid".equals(key2)) {
				dataDesc.setAppid(jsonObject2.getObject(key2, String.class));
			}else if ("version".equals(key2)) {
				dataDesc.setVersion(jsonObject2.getObject(key2, String.class));
			}else if ("pageName".equals(key2)) {
				dataDesc.setPageName(jsonObject2.getObject(key2, String.class));
			}else if ("pageType".equals(key2)) {
				dataDesc.setPageType(jsonObject2.getObject(key2, String.class));
			}else if ("operation".equals(key2)) {
				dataDesc.setOperation(jsonObject2.getObject(key2, String.class));
			}else if ("target".equals(key2)) {
				dataDesc.setTarget(jsonObject2.getObject(key2, String.class));
			}else if ("status".equals(key2)) {
				dataDesc.setStatus(jsonObject2.getObject(key2, String.class));
			}else if ("request".equals(key2) || "response".equals(key2)) {
				//TODO
				JSONObject jsonObject3 = jsonObject2.getJSONObject(key2);
				// toClassDesc
				ClassDesc classDesc = new ClassDesc();
				classDesc.setClassName(firstCharToUpperCase(jsonObject2.getObject("operation", String.class))+firstCharToUpperCase(key2));
				classDesc.setPackeName("");
				toClassDesc(jsonObject3,classDesc);
				
				dataClassDescList.add(classDesc);
				dataDesc.setClassDescList(dataClassDescList);
			}else {
				throw new RuntimeException("传入参数错误");
			}

		}
	}

	private static void toClassDesc(JSONObject jsonObject3,ClassDesc classDesc ) {
		
		List<ClassDesc> classDescList = new ArrayList();
		List<FieldDesc> fieldDescList = new ArrayList();
		Set<String> keySet3 = jsonObject3.keySet();
		
		for (String key3 : keySet3) {
			FieldDesc fieldDesc = new FieldDesc();
			JSONObject jsonObject4 = jsonObject3.getJSONObject(key3);
			String fieldType = jsonObject4.getObject("_type", String.class);
			if ("string".equals(fieldType) || "integer".equals(fieldType) || "long".equals(fieldType) || "double".equals(fieldType) || "float".equals(fieldType) ) {
				fieldDesc.setFieldType(firstCharToUpperCase(fieldType));
				fieldDesc.setOptional(jsonObject4.getObject("optional", Boolean.class));
				fieldDesc.setDefaultValue(jsonObject4.get("defaultValue"));
				fieldDesc.setNote(jsonObject4.getObject("note", String.class));
				fieldDesc.setFieldName(key3);
				fieldDescList.add(fieldDesc);
				classDesc.setFieldDescList(fieldDescList);
				
				
			}else if ("list".equals(fieldType)) {
				fieldDesc.setFieldType("List<"+ firstCharToUpperCase(key3) +">");
				fieldDesc.setOptional(jsonObject4.getObject("optional", Boolean.class));
				fieldDesc.setDefaultValue(jsonObject4.get("defaultValue"));
				fieldDesc.setNote(jsonObject4.getObject("note", String.class));
				fieldDesc.setFieldName(key3);
				fieldDesc.setImportType("import "+ArrayList.class.getCanonicalName()+";"+Const._R_N+"import "+firstCharToUpperCase(key3));
				fieldDescList.add(fieldDesc);
				classDesc.setFieldDescList(fieldDescList);
				ClassDesc classDesc2 = new ClassDesc();
				classDesc2.setClassName(firstCharToUpperCase(key3));
				classDesc2.setPackeName("package packageName");
				classDescList.add(classDesc2);
				
				toClassDesc(jsonObject4.getJSONObject("inner"), classDesc2);
				
			}else if ("timestamp".equals(fieldType)) {
				//TODO
				fieldDesc.setFieldType(firstCharToUpperCase(fieldType));
				fieldDesc.setOptional(jsonObject4.getObject("optional", Boolean.class));
				fieldDesc.setDefaultValue(jsonObject4.get("defaultValue"));
				fieldDesc.setNote(jsonObject4.getObject("note", String.class));
				fieldDesc.setFieldName(key3);
				fieldDesc.setImportType("import "+Timestamp.class.getCanonicalName());
				fieldDescList.add(fieldDesc);
				classDesc.setFieldDescList(fieldDescList);
			}else if ("date".equals(fieldType)) {
				//TODO
				fieldDesc.setFieldType(firstCharToUpperCase(fieldType));
				fieldDesc.setOptional(jsonObject4.getObject("optional", Boolean.class));
				fieldDesc.setDefaultValue(jsonObject4.get("defaultValue"));
				fieldDesc.setNote(jsonObject4.getObject("note", String.class));
				fieldDesc.setFormat(jsonObject4.getObject("format", String.class));
				fieldDesc.setImportType("import "+Date.class.getCanonicalName());
				fieldDesc.setFieldName(key3);
				fieldDescList.add(fieldDesc);
				classDesc.setFieldDescList(fieldDescList);
				
			}else if ("map".equals(fieldType)) {
				//TODO
				fieldDesc.setFieldType(firstCharToUpperCase(fieldType));
				fieldDesc.setOptional(jsonObject4.getObject("optional", Boolean.class));
				fieldDesc.setDefaultValue(jsonObject4.get("defaultValue"));
				fieldDesc.setNote(jsonObject4.getObject("note", String.class));
				fieldDesc.setFieldName(key3);
				fieldDesc.setKey(jsonObject4.get("key"));
				fieldDesc.setValue(jsonObject4.get("Value"));
				fieldDesc.setImportType("import "+Map.class.getCanonicalName()+";"+Const._R_N+"import "+HashMap.class.getCanonicalName());
				fieldDescList.add(fieldDesc);
				classDesc.setFieldDescList(fieldDescList);
				
				
				
			}else if ("any".equals(fieldType)) {
				fieldDesc.setFieldType(firstCharToUpperCase(key3));
				fieldDesc.setOptional(jsonObject4.getObject("optional", Boolean.class));
				fieldDesc.setNote(jsonObject4.getObject("note", String.class));
				fieldDesc.setFieldName(key3);
				fieldDesc.setImportType("import "+firstCharToUpperCase(key3)+";");
				fieldDescList.add(fieldDesc);
				classDesc.setFieldDescList(fieldDescList);
				ClassDesc classDesc2 = new ClassDesc();
				classDesc2.setPackeName("package packageName");
				classDesc2.setClassName(firstCharToUpperCase(key3));
				classDescList.add(classDesc2);

				JSONObject jsonObject5 = jsonObject4.getJSONObject("inner");
				toClassDesc(jsonObject5,classDesc2);
				
			}else {
				throw new RuntimeException("传入参数错误");
			}
		}
		classDesc.setClassDescList(classDescList);
	}
    private static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }
    private static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }
    
    private static void write(String s, File file) {
        try {
            if (file.exists()) {
                file.delete();
            } else {
                file.getParentFile().mkdirs();
            }

            BufferedWriter wb = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            wb.write(s);
            wb.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
