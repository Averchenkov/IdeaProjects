package semestr3.Lab3;

public class Test {
    public static void main(String[] args) {
        Boxer b = new Boxer(4, 3);
        b.birthday();
        System.out.println(b.getAge());
        System.out.println(b.getWool());

        Corgi c = new Corgi(4, 3);
        c.birthday();
        System.out.println(c.getAge());
        System.out.println(c.getWool());
    }
}