package semestr3.Pr5;

import java.util.Scanner;

public class Odds {
    public static void getOdds() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if ((num % 2) == 1) {
            System.out.println(num);
        }
        if (num == 0) {
            return;
        } else {
            getOdds();
        }
    }

    public static void main(String[] args) {
        getOdds();
    }
}