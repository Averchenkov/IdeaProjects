package semestr3.Pr5;

import java.util.Scanner;

public class Index {
    public static void getIndex(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num != 0){
            System.out.println(num);
        }
        if(sc.nextInt() != 0){
            getIndex();
        }
    }

    public static void main(String[] args) {
        getIndex();
    }
}
