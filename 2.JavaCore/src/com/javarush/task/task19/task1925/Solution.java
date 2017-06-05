package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(args[1]));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = fileIn.readLine()) != null)
            for (String word : line.split(" "))
                if (word.length() > 6)
                    sb.append(word + ",");
        //Удаляем запятую в конце
        sb.deleteCharAt(sb.length() - 1);
        fileOut.write(sb.toString());
        fileIn.close();
        fileOut.close();
    }
}
