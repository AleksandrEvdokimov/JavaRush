package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(path);
        load(inputStream);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties myProp = new Properties();
        myProp.putAll(properties);
        myProp.store(outputStream, "comment");
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties myProp = new Properties();
        myProp.load(inputStream);
        properties.clear(); // Очищаем текущую конфигурацию
        properties.putAll((Map) myProp);
        inputStream.close();
    }

    public static void main(String[] args) {

    }
}
