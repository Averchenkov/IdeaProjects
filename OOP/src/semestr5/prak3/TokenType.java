package semestr5.prak3;

import java.util.regex.Pattern;

public enum TokenType {
    NUMBER("[0-9]+"),
    ID("[_a-zA-Z][a-zA-Z0-9]*"),
    ADD("\\+"),
    SUB("-"),
    MUL("\\*"),
    DIV("/"),
    LPAR("\\("),
    RPAR("\\)"),
    SPACE("[ \t\r\n]+");
    Pattern pattern;
    TokenType(String regxp){
        pattern = Pattern.compile(regxp);
    }
}
