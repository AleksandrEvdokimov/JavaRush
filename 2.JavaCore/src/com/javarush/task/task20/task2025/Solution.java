package com.javarush.task.task20.task2025;

/* 
Алгоритмы-числа
*/
import java.util.*;

public class Solution {
    public static long[] getNumbers(long N) {
        List list = ArmstrongNumbersMultiSetLongOpt.generate((int) (Math.log10(N)));
        long[] a = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = (long)list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        long[] numbers = getNumbers(999999999);
        for (long i : numbers)
            System.out.print(i + " ");
    }
}
