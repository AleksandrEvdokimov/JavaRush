package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Byte> letters = new ArrayList<Byte>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileInputStream input = new FileInputStream(file);
        byte[] buffer = new byte[input.available()];
        if (input.available() > 0)
            input.read(buffer);
        input.close();

        for (int i = 0; i < buffer.length; i++) {
            if (!letters.contains(buffer[i]))
                letters.add(buffer[i]);
        }

        Collections.sort(letters);
        for (Byte b : letters)
            System.out.print(b + " ");
    }
}
