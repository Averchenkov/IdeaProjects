package lab1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Mouse> mice = new ArrayList<Mouse>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char key;
        do {
            System.out.println("Choose what you want to do in program:");
            System.out.println(" 1 - Display all mouse");
            System.out.println(" 2 - Create new mouse");
            System.out.println(" 3 - Search mouse");
            System.out.println(" 4 - Exit program");
            key = sc.nextLine().charAt(0);
            switch (key) {
                case '1': {
                    display();
                    break;
                }
                case '2': {
                    create();
                    break;
                }
                case '3': {
                    search();
                    break;
                }
                case '4': {
                    System.out.println("Stop program");
                    break;
                }
                default:
                    System.out.println("Error try again");
            }
        } while (key != '4');
    }

    private static void display(){
        System.out.println("all mice in base:");
        for (int i = 0; i < mice.size(); i++) {
            System.out.println(i+1 + "= " + mice.get(i).toString());
        }
    }

    private static void create(){
        System.out.println("Choose what you want to create in database:");
        System.out.println(" 1 - Create Wireless Mouse");
        System.out.println(" 2 - Create Gaming Mouse");
        System.out.println(" 3 - Create Wired Mouse");
        System.out.println(" 4 - exit");
        char key = sc.nextLine().charAt(0);
        Mouse mouse;
        switch (key){
            case '1':{
                mouse = new WirelessMouse();
                System.out.print("Work time (integer): ");
                ((WirelessMouse) mouse).setWorkTime(Integer.parseInt(sc.nextLine()));
                System.out.print("Weight (double):");
                ((WirelessMouse) mouse).setWeight(Double.parseDouble(sc.nextLine()));
                break;
            }
            case '2':{
                mouse =  new GamingMouse();
                System.out.print("Dpi (double): ");
                ((GamingMouse) mouse).setDpi(Double.parseDouble(sc.nextLine()));
                System.out.print("Num buttons (integer):");
                ((GamingMouse) mouse).setNumButtons(Integer.parseInt(sc.nextLine()));
                break;
            }
            case '3':{
                mouse =  new WiredMouse();
                System.out.print("Length cable (double): ");
                ((WiredMouse) mouse).setLengthCable(Double.parseDouble(sc.nextLine()));
                System.out.print("size (double): ");
                ((WiredMouse) mouse).setSize(Double.parseDouble(sc.nextLine()));
                break;
            }
            case '4':{
                System.out.println("exit from create");

                return;
            }
            default:
                System.out.println("Error try again");
                return;
        }

        System.out.print("Model: ");
        mouse.setModel(sc.nextLine());
        System.out.print("Color: ");
        mouse.setColor(sc.nextLine());
        System.out.print("Producer: ");
        mouse.setProducer(sc.nextLine());
        System.out.print("Producer Country: ");
        mouse.setProducerCountry(sc.nextLine());


        mice.add(mouse);
        return;
    }

    private static void search(){
        char key;
        do {
            System.out.println(" 1 - Search for specific object");
            System.out.println(" 2 - Contains a string");
            System.out.println(" 3 - Exit from seach");
            key = sc.nextLine().charAt(0);
            switch (key) {
                case '1': {
                    searchFor();
                    break;
                }
                case '2': {
                    System.out.println("String to search: ");
                    String search = sc.nextLine();
                    Iterator iter = mice.iterator();
                    String temp;
                    while (iter.hasNext()) {
                        temp = iter.next().toString();
                        if (temp.contains(search))
                            System.out.println(temp + "\n");
                    }
                    break;
                }
                case '3': {
                    System.out.println("Exit from search");
                }
                default:
                    System.out.println("Error. Try again");
            }
            System.out.println("\n--------End search.");
        } while (key != '3');
    }

    private static void searchFor() {
        char menu;
        do {
            System.out.println("1. Search for Wireless Mouse;");
            System.out.println("2. Search for Gaming Mouse;");
            System.out.println("3. Search for Wired Mouse;");
            System.out.println("0. Exit.");
            menu = sc.nextLine().charAt(0);
            Iterator iter = mice.iterator();
            Mouse temp;

            switch (menu) {
                case '1': {
                    while (iter.hasNext()) {
                        temp = (Mouse) iter.next();
                        if (temp instanceof WirelessMouse) {
                            System.out.println(temp.toString());
                        }
                    }
                    break;
                } case '2': {
                    while (iter.hasNext()) {
                        temp = (Mouse) iter.next();
                        if (temp instanceof GamingMouse) {

                            System.out.println(temp.toString());
                        }
                    }
                    break;
                } case '3': {
                    while (iter.hasNext()) {
                        temp = (Mouse) iter.next();
                        if (temp instanceof WiredMouse)
                            System.out.println(temp.toString());
                    }
                    break;
                }
            }
            System.out.println("\n--------End search.");
        }
        while (menu != '0' & menu != 'O' & menu != 'o');
    }
}
