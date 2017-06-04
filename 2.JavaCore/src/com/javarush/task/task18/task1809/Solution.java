package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream filereader = new FileInputStream(file1);
        byte[] buffer = new byte[filereader.available()];
        byte[] reverse_buffer = new byte[filereader.available()];
        if (filereader.available() > 0)
            filereader.read(buffer);
        filereader.close();
        int count = 0;
        int reverse_count = buffer.length - 1;
        while (count < buffer.length) {
            reverse_buffer[count] = buffer[reverse_count];
            count++;
            reverse_count--;
        }
        FileOutputStream filewriter = new FileOutputStream(file2);
        filewriter.write(reverse_buffer);
        filewriter.close();
    }
}
