package config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigReader {

    private static Map<String, Object> config;

    static {
        loadYaml();
    }

    private static void loadYaml() {
        Yaml yaml = new Yaml();
        InputStream inputStream =
                ConfigReader.class.getClassLoader().getResourceAsStream("config.yaml");

        config = yaml.load(inputStream);
    }

    public static String getBrowser() {
        return config.get("browser").toString();
    }

    public static String getUrl() {
        return config.get("url").toString();
    }

    public static Boolean isHeadless() {
        return Boolean.parseBoolean(config.get("headless").toString());
    }

    public static int getTimeout() {
        return Integer.parseInt(config.get("timeout").toString());
    }
}
