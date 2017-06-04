package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);

        int count = 1; //Переменная для подчета количества считанных байт
        while (fileReader.ready()) {
            int data = fileReader.read();
            count++;
            if (count % 2 != 0)
                fileWriter.write(data);
        }
        fileReader.close();
        fileWriter.close();
    }
}
