package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread myThread = new TestThread();
        myThread.start();
        myThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        public void run() {
            System.out.println("My test thread.");
        }
    }
}