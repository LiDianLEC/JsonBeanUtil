package jerry.jsonbeans;

import jerry.jsonbeans.models.ClassDescribe;
import jerry.jsonbeans.utils.FileUtils;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Config.me().init();

        String[] strings = FileUtils.readFile(FileUtils.filePath("jsonbeans.txt"));

        ClassDescribe classInfo = new ClassDescribe(strings[0], strings[1]);

        JsonBeans.json2bean(strings[2], classInfo);
    }
}
