package semestr3.Lab1;

import java.lang.System;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!!!");

        int sum = 0, num, c = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");

        if(sc.hasNextInt()) {
            c =sc.nextInt();
        } else {
            System.out.print("You didn't enter a number :<(");
        }
        for (int i =1; i <= c;i++){
            System.out.print(i + ": ");
            sum += sc.nextInt();
        }

        System.out.print("The sum is: " + sum);

        for (int i =1; i < 10;i++){
            System.out.println((double)1/i);
        }

        Random rnd = new Random();

        int length = 15;
        int[] arr = new int[length];

        for (int i = 0; i <= length-1; i++) {
            arr[i] = rnd.nextInt(99) + 1;
            System.out.println(arr[i]);
        }
        Arrays.sort(arr);
        System.out.print("\nSorted: \n");

        for (int i = 0; i <= length-1; i++) {
            System.out.println(arr[i]);
        }

        num = 10;
        int result = 1;
        for (int i = num; i > 0; i--) {
            result *= i;
        }
        System.out.print("The result is: " + result);
    }
}

