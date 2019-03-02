package semestr3.test.Test3;

public class Main {
    public static class A{
        private int c;
        private int d;

        public A(int c, int d) {
            this.c = c;
            this.d = d;
        }

        public int getC() {
            return c;
        }

        public int getD() {
            return d;
        }

        public void setC(int c) {
            this.c = c;
        }

        public void setD(int d) {
            this.d = d;
        }
    }

    public static void test(A a){
        int e = a.getC();
        a.setC(a.getD());
        a.setD(e);
    }

    public static void main(String[] args) {
        A a = new A(3, 6);
        test(a);
        System.out.println(a.getC() + " " + a.getD());
    }
}
