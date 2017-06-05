package com.javarush.task.task19.task1926;

/*
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        BufferedReader fileIn = new BufferedReader(new FileReader(path));
        String line;
        while ((line = fileIn.readLine()) != null)
        {
            StringBuffer sb = new StringBuffer();
            sb.append(line).reverse();
            System.out.println(sb.toString());
        }
        fileIn.close();
    }
}
