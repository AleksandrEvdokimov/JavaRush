package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        BufferedReader fileIn = new BufferedReader(new FileReader(path));
        StringBuffer sb = new StringBuffer();
        while (fileIn.ready())
        {
            sb.append((char) fileIn.read());
        }
        fileIn.close();
        ArrayList<Integer> startIndexes = new ArrayList<>();
        ArrayList<Integer> endIndexes = new ArrayList<>();
        String result = sb.toString();
        int index =  0;
        //Записываем индексы открывающих тегов в список
        while (true)
        {
            index = sb.indexOf("<" + args[0], index);
            if (index == - 1) break;
            startIndexes.add(index);
            index += args[0].length();
        }
        //Записываем индексы закрываемых тегов в список
        index = 0;
        while (true)
        {
            index = sb.indexOf("/" + args[0], index);
            if (index == - 1) break;
            endIndexes.add(index);
            index += args[0].length();
        }
        //Выводим в результат в консоль
        while (!startIndexes.isEmpty()) {
            int n = 0;
            for (int i = 1; i < startIndexes.size(); i++) if (startIndexes.get(i) < endIndexes.get(0)) n++;
            System.out.println(sb.substring(startIndexes.get(0), endIndexes.get(n)) + "/" + args[0] + ">");
            startIndexes.remove(0);
            endIndexes.remove(n);
        }
    }
}
