package semestr3.Lab2;

import java.lang.*;


public class BookTest {


    public static void main(String[] args) {
        Book book = new Book("Crime and punishment", "Dostoevsky", 1866, 400, 20);
        System.out.println(book);
        book.setAuthor("Pushkin");
        book.setCurrentPage(50);
        System.out.println(book.getCurrentPage());
        book.setCurrentPage(80);
        System.out.println(book);
    }

}
