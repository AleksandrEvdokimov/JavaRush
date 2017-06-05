package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        BufferedReader fileIn = new BufferedReader(new FileReader(path));
        String line;
        while ((line = fileIn.readLine()) != null)
        {
            int count = 0;
            for (String word : line.split(" "))
                for (String sample : words)
                    if (sample.equals(word))
                        count++;
            if (count == 2)
            System.out.println(line);
        }
        fileIn.close();
    }
}
