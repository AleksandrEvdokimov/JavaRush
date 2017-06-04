package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.DoubleSummaryStatistics;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String s = reader.readLine();
            if (s.contains("exit"))
                break;
            else if (s.contains(".") && isDouble(s)) {
                print(Double.parseDouble(s));
            }
            else if (isInteger(s)) {
                int i = Integer.parseInt(s);
                if (i > 0 && i < 128)
                    print((short) i);
                else if (i <=0 || i >= 128)
                        print(i);
            }
            else
                print(s);
        }
    }
    // Метод проверяет является ли введенная строка Int
    public static boolean isInteger (String s)
    {
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
    // Метод проверяет является ли введенная строка Double
    public static boolean isDouble (String s)
    {
        try {
            Double.parseDouble(s);
        }
        catch (NumberFormatException e) {
            return false;}
        return true;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
