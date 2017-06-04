package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        /*args[0] = "/home/saneok777/Yandex.Disk/file_for_test";*/
        FileInputStream inputStream = new FileInputStream(new File(args[0]));
        int count = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data >= 65 && data <= 90 || data >= 97 && data <= 122)
            count++;
        }
        inputStream.close();
        System.out.println(count);
    }
}
