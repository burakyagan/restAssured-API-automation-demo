package com.trendyol.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties; // Properties dosyasındaki değerleri okur ve bellekte tutar. Properties dosyası bir kez okunmalı, bu yüzden static.

    static {
        properties = new Properties(); //Boş bir Properties objesi --> Dosyadan değerler yüklenmesi için
        InputStream inputStream = ConfigReader.class.getResourceAsStream("/properties/config.properties");

        try {
            if(inputStream == null) {
                throw new RuntimeException("Config file not found");
            }
            properties.load(inputStream); // inputStream null değilse bunu load et
            inputStream.close();          // dosyayla işimiz bitti, okumayı bırak (memory leak için önemli !)
        }
        catch (Exception e) { //try bloğu esnasında bir hata çıkarsa yakala
            throw new RuntimeException("Failed to load config file",e);
        }

    }

    public static String getProperty(String key) {      //Hafızaya yüklenmiş olan config.properties dosyanızın içinde (key-value) araması yapar.
        return properties.getProperty(key);
    }

    public static String getBaseUri() {     //Helper methodları. Eğer olmasaydı, ApiBaseTest sınıfım şöyle görünürdü: .setBaseUri(ConfigReader.getProperty("base.uri")) --> ABSTRACTION
        return getProperty("base.uri");
    }

    public static String getApiKey() {      //Helper methodları. BaseUri ile aynı mantık. ABSTRACTION sağlar.
        return getProperty("api.key");
    }
}

