package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close(); //закрываем поток для чтения
        String id = "";
        ArrayList<Integer> ids = new ArrayList<>();
        if ("-c".equals(args[0])) {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while (in.ready()) {
                id = in.readLine().substring(0, 8);
                id = id.replaceAll(" ", "");
                ids.add(Integer.parseInt(id));
        }
        in.close();// закрываем поток чтения из файла
                // сюда возвращать максимальный id
            id = String.valueOf (Maxid(ids) + 1);
                if (id.length() < 8)
                    for (int i = id.length(); i < 8; i++)
                        id += " ";
        }
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        if (productName.length() < 30)
            for (int i = productName.length(); i < 30; i++)
                productName += " ";
        else if (productName.length() > 30)
            productName = productName.substring(0, 30);
        if (price.length() < 8)
            for (int i = price.length(); i < 8; i++)
                price += " ";
        else if (price.length() > 8)
            price = price.substring(0, 8);
        if (quantity.length() < 4)
            for (int i = quantity.length(); i < 4; i++)
                quantity += " ";
        else if (quantity.length() > 4)
            quantity = quantity.substring(0, 4);

        String line = id + productName + price + quantity;
        FileWriter writer = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("\n");
        bufferedWriter.write(line);
        bufferedWriter.close(); //Закрываем поток записи
    }
    private static int Maxid(ArrayList<Integer> list) //функция поиска максимального id
    {
        int maxId = list.get(0);
        for (Integer i : list)
            if (maxId < i)
                maxId = i;
        return maxId;
    }
}
