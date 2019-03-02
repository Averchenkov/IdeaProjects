package semestr3.Lab3;

public class Corgi extends Dog {
    Corgi(int age,int wool){
        super(age, wool);
    }
    public void birthday() {
        age++;
        wool += 2;
    }

}
