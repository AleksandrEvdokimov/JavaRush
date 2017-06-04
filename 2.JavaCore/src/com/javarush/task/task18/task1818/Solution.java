package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] files = new String[3];
        for (int i = 0; i < files.length; i++) {
            files[i] = reader.readLine();
        }
        reader.close();
        FileOutputStream file1 = new FileOutputStream(files[0], true);
        FileInputStream file2 = new FileInputStream(files[1]);
        FileInputStream file3 = new FileInputStream(files[2]);
        while (file2.available() > 0) {
            int data = file2.read();
            file1.write(data);
        }
        file2.close();
        file1.flush();
        while (file3.available() > 0) {
            int data = file3.read();
            file1.write(data);
        }
        file3.close();
        file1.close();
    }
}
