package semestr5.prak3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Lexer {
    String src;
    int pos = 0;
    List<Token> tokens = new ArrayList<>();

    public Lexer(String src) {
        this.src = src;
        this.pos = 0;
    }

    boolean nextToken() {
        if (pos >= src.length())
            return  false;
        for (TokenType tt: TokenType.values()){
            Matcher m = tt.pattern.matcher(src);
            m.region(pos, src.length());
            if (m.lookingAt()){
                Token t = new Token(tt, m.group(), pos);
                tokens.add(t);
                pos = m.end();
                return true;
            }
        }
        throw new RuntimeException(
                "Неизвестный символ" + pos
        );
    }

    List<Token> lex(){
        while (nextToken()){
        }
        return tokens;
    }

    public static void main(String[] args) {
        String text = "10 + 20";
        Lexer l = new Lexer(text);
        List<Token> tlist = l.lex();
        for (Token t : tlist){
            System.out.println(t.type + " " + t.text);
        }
    }
}


