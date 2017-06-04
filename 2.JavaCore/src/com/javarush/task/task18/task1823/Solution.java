package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("exit"))
                break;
             new ReadThread(fileName).start();

        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                FileInputStream in = new FileInputStream(fileName);
                Map<Integer, Integer> buffer = new HashMap<>();
                while (in.available() > 0) {
                    int data = in.read();
                    if (buffer.containsKey(data))
                        buffer.put(data, buffer.get(data) + 1); // Если такой байт уже есть увеличиваем его значение на 1
                    else
                        buffer.put(data, 1);
                }
                in.close();
                int max = 0;
                for (Map.Entry<Integer, Integer> m : buffer.entrySet()) //Ищем максимально повторяющийся байт
                    if (m.getValue() > max)
                        max = m.getValue();

                synchronized (this) {
                    for (Map.Entry<Integer, Integer> m : buffer.entrySet()) //Пихаем имя нити(файла) в resultMap
                        if (m.getValue() == max)
                            resultMap.put(fileName, m.getKey());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
