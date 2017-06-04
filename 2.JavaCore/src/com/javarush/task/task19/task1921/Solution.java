package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        String line;
        while((line = fileIn.readLine()) != null)
        {
            String name = "";
            String date = "";
            for (String s : line.split(" "))
            {
                if (!isDigit(s))
                    name += s + " ";
                else
                    date += s + " ";
            }
            name = name.trim();
            date = date.trim();
            Date birthday = new SimpleDateFormat("dd MM yyyy").parse(date);
            PEOPLE.add(new Person(name, birthday));
        }
        fileIn.close();


    }
    static boolean isDigit(String s)
    {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
