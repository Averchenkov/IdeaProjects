package semestr5.testp2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("...");
        String text = "x1=xy-237";
        Matcher m = p.matcher(text);
        while (m.find()){
            String id = m.group();
            System.out.println(id);
            int s = m.start();
            int e = m.end();
        }
    }
}
