package semestr3.Lab2;

public class Book {
    private String name;
    private String author;
    private int publishYear;
    private int pages;
    private int currentPage;

    public Book(String name, String author, int publishYear, int pages, int currentPage){
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.pages = pages;
        this.currentPage = currentPage;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPublishYear(int publishYear){
        this.publishYear = publishYear;
    }
    public void setPages(int pages){
        this.pages = pages;
    }
    public void setCurrentPage(int currentPage){
        this.currentPage = currentPage;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public int getPublishYear(){
        return publishYear;
    }
    public int getPages(){
        return pages;
    }
    public int getCurrentPage(){
        return currentPage;
    }
    public String toString(){
        return name + " " + author + " " + publishYear + " year " + pages + " pages, current page is " + currentPage;
    }
}
