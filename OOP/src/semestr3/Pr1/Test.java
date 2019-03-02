package semestr3.Pr1;

        import java.lang.*;

public class Test {
    public static void main(String[] args) {
        Ball b1 = new Ball();
        Ball b2 = new Ball(30, "green");
        Ball b3 = new Ball(20);
        b3.setColor("black");
        b1.inflate();
        b2.inflate(400);
        b2.deflate(600);
        b3.inflate();
        b3.inflate(500);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

    }
}
