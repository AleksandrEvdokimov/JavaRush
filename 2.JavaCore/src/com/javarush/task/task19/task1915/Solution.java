package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Считываем имя файла для записи
        String filePath = reader.readLine();
        reader.close();
        //Сохраняем поток из переменной System.out в переменную consoleStream
        PrintStream consoleStream = System.out;
        //Создаем динамический массив байтов для записи данных из потока вывода
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //Создаем объект потока-вывода console для записи в массив ouputStream
        PrintStream console = new PrintStream(outputStream);
        //Присваиваем переменной System.out новый объект для потока вывода
        System.setOut(console);
        //Вызываем функцию вывода текста
        testString.printSomething();
        //Возвращаем изначальный поток вывода переменной System.out
        System.setOut(consoleStream);
        //Таки выводм текст на экран
        System.out.println(outputStream.toString());
        //Дублируем вывод в файл
        FileOutputStream fileOut = new FileOutputStream(filePath);
        fileOut.write(outputStream.toByteArray());
        //Закрываем поток вывода в файл
        fileOut.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

