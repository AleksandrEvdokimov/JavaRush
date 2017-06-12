package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution savedObject = new Solution(10);
        Solution loadedObject = new Solution(20);
        ObjectOutput oos = new ObjectOutputStream(new FileOutputStream("/home/saneok/Yandex.Disk/object.dat"));
        oos.writeObject(savedObject);
        oos.flush();
        oos.close();

        ObjectInput ois = new ObjectInputStream(new FileInputStream("/home/saneok/Yandex.Disk/object.dat"));
        loadedObject = (Solution) ois.readObject();
        ois.close();

        System.out.println(savedObject.string);
        System.out.println(loadedObject.string);
        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public Solution(){}

    @Override
    public String toString() {
        return this.string;
    }
}