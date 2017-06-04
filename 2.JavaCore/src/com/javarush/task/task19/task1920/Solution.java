package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        String line;
        while ((line = fileIn.readLine()) != null) {
            String name = line.split(" ")[0];
            double money = Double.parseDouble(line.split(" ")[1]);
            if (map.containsKey(name)) {
                double sum = map.get(name) + money;
                map.put(name, sum);
            }
            else
                map.put(name, money);
        }
        fileIn.close();
        double maxValue = Collections.max(map.values());
        for (Map.Entry<String, Double> i : map.entrySet())
            if (i.getValue().equals(maxValue))
                System.out.println(i.getKey());
    }
}
