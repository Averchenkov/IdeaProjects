package semestr5.FL;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testFL {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[0-9]+");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\Aver\\Documents\\GitHub\\IdeaProjects\\OOP\\src\\semestr5\\FL\\test"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                String found = m.group();
                int s =  m.start();
                int e = m.end();
                System.out.println(found);
                System.out.println(s);
                System.out.println(e);
            }
        }
    }
}
