package testirovanie;

public class Calculator {
    public static int difference(int a, int b){
        return a-b;
    }


    public static int divide(int a, int b){
        if(b == 0){
            throw new ArithmeticException("divide by 0");
        }
        return a/b;
    }

    public static double root(double a){
        String s = "djfaslkdjfflekjwfljafljfalej";
        if(a < 0){
            throw new ArithmeticException("negative root");
        }
        return Math.sqrt(a);
    }
}
