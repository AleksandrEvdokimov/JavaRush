package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        String line;
        Map<String, Double> map = new TreeMap<>();
        while ((line = fileIn.readLine()) != null) {
            String name = line.split(" ")[0];
            String money = line.split(" ")[1];
            if (!map.containsKey(name))
                map.put(name, Double.parseDouble(money));
            else {
                double sum = map.get(name) + Double.parseDouble(money);
                map.put(name, sum);
            }
        }
        fileIn.close();

        for (Map.Entry<String, Double> i : map.entrySet())
            System.out.println(i.getKey() + " " + i.getValue());
    }
}
