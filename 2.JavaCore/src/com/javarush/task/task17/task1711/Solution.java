package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    public static Date bd = null;
    public static int id;
    public static String sex = null;
    public static Person temp = null;

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        // if (args.length > 0) // Switch starting if args > 0
        switch (args[0]){
            case "-c" : synchronized (allPeople) {
                addPerson(args);}
                break;
            case "-u" : synchronized (allPeople) {
                updatePerson(args);}
                break;
            case "-d" : synchronized (allPeople) {
                logicDel(args);}
                break;
            case "-i" : synchronized (allPeople) {
                displayInfo(args);}
                break;
            default:
                System.out.println("Неправельный аргумент");
                break;
        }
    }

    public static void addPerson(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i+=3) {
            if (args[i+1].equals("м"))
                allPeople.add(Person.createMale(args[i], format1.parse(args[i+2])));
            else if (args[i+1].equals("ж"))
                allPeople.add(Person.createFemale(args[i], format1.parse(args[i+2])));
            else
                return;
            System.out.println(allPeople.size() - 1);
        }
    }

    public static void updatePerson(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i+=4) {
            id = Integer.parseInt(args[i]);
            bd = format1.parse(args[i+3]);
            if (args[i+2].equals("м"))
                temp = Person.createMale(args[i+1], bd);
            else if (args[i+2].equals("ж"))
                temp = Person.createFemale(args[i+1], bd);
            else
                return;
            allPeople.set(id, temp);
        }
    }

    public static void logicDel(String[] args){
        for (int i = 1; i < args.length; i++) {
            id = Integer.parseInt(args[i]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);
        }
    }

    public static void displayInfo(String[] args){
        for (int i = 1; i < args.length; i++) {
            id = Integer.parseInt(args[i]);
            bd = allPeople.get(id).getBirthDay();
            if (allPeople.get(id).getSex().equals(Sex.MALE))
                sex = "м";
            else sex = "ж";
            System.out.println(allPeople.get(id).getName() + " " + sex + " " + format2.format(bd));
        }
    }
}

