package jerry.jsonbeans;

import jerry.jsonbeans.utils.FileUtils;

import java.util.Properties;

/**
 * @author Jerry Ou
 * @version 1.0 2016-05-03 14:07
 * @since JDK 1.6
 */
public class Config {

    private Config() {

    }

    private static class InstanceHolder {
        private static Config instance = new Config();
    }

    public static Config me() {
        return InstanceHolder.instance;
    }

    private Properties properties;

    public void init() {
        String file = FileUtils.filePath(Const.CONFIG_FILE);
        Properties temp = new Properties();
        FileUtils.loadProperties(temp, file);
        this.properties = temp;
    }

    public Object get(String key) {
        return properties.get(key);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public boolean getBoolean(String key) {
        String s = properties.getProperty(key);
        if (s == null) {
            return Boolean.FALSE;
        }
        return Boolean.parseBoolean(s);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        String s = properties.getProperty(key);
        if (s == null) {
            return defaultValue;
        }
        return Boolean.parseBoolean(s);
    }

}
