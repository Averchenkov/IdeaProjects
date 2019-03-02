package semestr3.Lab3;

public abstract class Dog {
    protected int age;
    protected int wool;
    Dog(int age, int wool){
        this.age = age;
        this.wool = wool;
    }

    public int getAge() {
        return age;
    }

    public int getWool() {
        return wool;
    }

    public abstract void birthday();
}