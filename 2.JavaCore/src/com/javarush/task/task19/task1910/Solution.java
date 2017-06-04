package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new FileReader(file1));
        BufferedWriter out = new BufferedWriter(new FileWriter(file2));
        StringBuilder sb = new StringBuilder();
        while (in.ready()) {
            sb.append((char) in.read());
        }

        String str = sb.toString();
        /*str = str.replaceAll("\\n", "");
        str = str.replaceAll("\\pP", "");
        str = str.replaceAll(" ", "");*/
        str = str.replaceAll("[\\n]|[\\pP]|[ ]", "");

        out.write(str);
        in.close();
        out.close();
    }
}
