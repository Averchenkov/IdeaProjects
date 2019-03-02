package semestr3.Lab7;

import java.util.*;

public class Main{

    public static void main(String[] args) {

        ArrayList<String> things = new ArrayList<String>();
        things.add("Стул");
        things.add("Стол");
        things.add("Кровать");
        things.add("Диван");
        things.add("Табуретка");
        things.add(3, "Шкаф");

        Iterator<String> iterator = things.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("Отсортированый в алфавитном порядке:");
        Collections.sort(things);
        iterator = things.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();


        things.set(1, "Табуретка");

        System.out.println("В доме " + things.size() + " вещей/вещи");
        iterator = things.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        if(things.contains("Стул")){

            System.out.println("В доме есть стул");
        }
        else{
            System.out.println("В доме нет стула");
        }
        System.out.println("В доме " + Collections.frequency(things, "Табуретка") + " табуретки/табуреток");


        things.remove("Шкаф");
        things.remove(1);

        System.out.println("После удаления");
        iterator = things.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();


    }
}