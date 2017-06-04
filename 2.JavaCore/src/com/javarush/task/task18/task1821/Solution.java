package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*args[0] = "/home/saneok777/Yandex.Disk/file_for_test";*/
        FileInputStream file  = new FileInputStream(args[0]);
        Map<Character, Integer> map = new TreeMap<>();
        while (file.available() > 0) {
            char c = (char) file.read();
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        file.close();
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

