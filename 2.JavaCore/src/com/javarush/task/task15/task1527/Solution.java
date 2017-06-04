package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        reader.close();


        String sub_URL = URL.substring(URL.indexOf("?") + 1);

        String[] param_list = sub_URL.split("&");
        // Выводим массив параметров на экран

        for (String i : param_list) {

            System.out.print(i.split("=")[0] + " ");
        }
        //тупо добавляем пустую строку для того чтобы вывод соответствовал заданию
        System.out.println();

        for (String i : param_list)
        {
            if (i.indexOf("obj") != -1)
            {
                if (isDouble(i.split("=")[1]))
                    alert(Double.parseDouble(i.split("=")[1]));
                else
                    alert(i.split("=")[1]);
            }
        }
    }

    public static boolean isDouble(String i){
        try {
            Double.parseDouble(i);
            return true;
        }
        catch (NumberFormatException e)
        {return false;}
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
