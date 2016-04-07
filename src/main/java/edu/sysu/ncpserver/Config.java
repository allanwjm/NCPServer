package edu.sysu.ncpserver;

import java.io.FileInputStream;

/**
 * Created by mura on 3/29/16
 */
public class Config {

    ////////////////////////////////////////////////////////////////////////////////
    // Config properties
    ////////////////////////////////////////////////////////////////////////////////
    // Config file path
    private static final String CONFIG_PROPERTIES = "config.properties";

    // java.util.Config instance
    private static java.util.Properties config;

    // Get java.util.Config instance
    private static java.util.Properties getConfig() {
        if (config == null) {
            synchronized (Config.class) {
                if (config == null) {
                    config = new java.util.Properties();
                    try {
                        String path = Config.class.getResource("/").toURI().getPath() + CONFIG_PROPERTIES;
                        FileInputStream fis = new FileInputStream(path);
                        config.load(fis);
                        fis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return config;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Config property Getters
    ////////////////////////////////////////////////////////////////////////////////
    public static String getString(String key) {
        return getConfig().getProperty(key);
    }

    public static Integer getInteger(String key) {
        return Integer.parseInt(getString(key));
    }

    public static Double getDouble(String key) {
        return Double.parseDouble(getString(key));
    }

}
