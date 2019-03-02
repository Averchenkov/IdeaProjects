package semestr3.Pr5;

public class Polindrom {
    public static boolean isPolindrom(String s){
        if ((s.length() > 1) && (s.charAt(0) == s.charAt(s.length() - 1))){
            return isPolindrom(s.substring(1, s.length() - 1));
        }
        else if ((s.length() > 1) && (s.charAt(0) != s.charAt(s.length() - 1))){
            return false;
        }
        else{
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPolindrom("abbba"));
    }
}
