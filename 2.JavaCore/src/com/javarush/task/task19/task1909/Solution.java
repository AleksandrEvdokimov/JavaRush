package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new FileReader(fileIn));
        BufferedWriter out = new BufferedWriter(new FileWriter(fileOut));
        StringBuffer sb = new StringBuffer();
        while (in.ready()) {
            char c = (char) in.read();
            if (c == '.')
                c = '!';
            sb.append(c);
        }
        out.write(sb.toString());
        in.close();
        out.close();
    }
}
