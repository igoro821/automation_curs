package com.company;

import java.util.Properties;
import java.io.*;

/**
 * Created by student on 11.10.2016.
 */
public class DbConfig {

    private static Properties props;

    static {
        props = new Properties();
        InputStream stream = DbConfig.class.getResourceAsStream("/files/db.properties");
        try {
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return props.getProperty(key);
    }
}
