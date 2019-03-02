package semestr3.Pr4;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(215, 200);
        g.setResizable(false);
    }
}
