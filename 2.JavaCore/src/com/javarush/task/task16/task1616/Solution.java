package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* 
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        //После того как произошел ввод из консоли, прерываем выполнение нити
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            //Пытаемся выполнить код, если нить еще не прервана
            try {
                //add your code here - добавьте код тут
                while (!currentThread().isInterrupted()) {
                    seconds++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) //Если нить уже прерванна, т.е. пользователь введ данные в консоль - выкидывается это исключение.
            {
                System.out.println(seconds);
            }
        }
    }
}
