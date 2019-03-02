package semestr3.Lab3;

public class Boxer extends Dog {
    Boxer(int age,int wool){
        super(age, wool);
    }
    public void birthday() {
        age++;
        wool++;
    }
}