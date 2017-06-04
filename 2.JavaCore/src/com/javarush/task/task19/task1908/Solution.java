package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader fileIn = new BufferedReader(new FileReader(file1));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(file2));
        StringBuilder sb = new StringBuilder();
        while (fileIn.ready())
                sb.append((char) fileIn.read());

        String[] m = sb.toString().split(" ");
        for (String s : m)
            if (isNumberic(s))
        fileOut.write(s + " ");

        fileIn.close();
        fileOut.close();
    }

     public static boolean isNumberic (String s)
    {
        try
        {
            Double.parseDouble(s);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
            return true;
        }
}
