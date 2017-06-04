package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);
        byte[] buffer = new byte[in.available()];
        if (in.available() > 0)
            in.read(buffer);
        if (args[0].equals("-e"))
            buffer = crypt(buffer);
        else if (args[0].equals("-d"))
            buffer = decrypt(buffer);

        out.write(buffer);
        in.close();
        out.close();
    }

private static byte[] crypt(byte[] buffer) {
    for (int i = 0; i < buffer.length; i++)
        buffer[i] += 1;
        return buffer;
}
private static byte[] decrypt(byte[] buffer) {
    for (int i = 0; i < buffer.length; i++)
        buffer[i] -= 1;
        return buffer;
}
}
