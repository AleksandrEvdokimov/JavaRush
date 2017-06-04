package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name1 = reader.readLine();
        String file_name2 = reader.readLine();
        reader.close();
        FileInputStream file1 = new FileInputStream(new File(file_name1)); // инициализируем поток ввода
        String buffer = "";
        ArrayList<String> list  = new ArrayList<>();
        while (file1.available() > 0) {
            int data = file1.read();
            buffer += (char) data;
        }

        for (String s : buffer.split(" ")) {
            int f = Math.round(Float.parseFloat(s));
            list.add(f + " ");
        }

        FileOutputStream file2 = new FileOutputStream(file_name2);
        for (String s : list)
            file2.write(s.getBytes());

        file1.close();
        file2.close();
    }
}
