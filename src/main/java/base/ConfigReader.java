package base;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    private static final String DEFAULT_PROP_NAME = "config.properties";
    private static final String CONFIG_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    private static Properties properties = new Properties();
    private static InputStream inpstrm = null;

    private static void loadConfigPropertiesFile(String path) {
        try {
            File file = new File(CONFIG_PATH + path);
            inpstrm = new FileInputStream(file);
            properties.load(new InputStreamReader(inpstrm));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            IOUtils.closeQuietly(inpstrm);
        }
    }

    public static String getValueByKey(String key) {
        loadConfigPropertiesFile(DEFAULT_PROP_NAME);
        Object obj = properties.get(key);
        if (obj == null) {
            throw new IllegalStateException("Value is null, key is : " + key);
        }
        return String.valueOf(obj);
    }
}
