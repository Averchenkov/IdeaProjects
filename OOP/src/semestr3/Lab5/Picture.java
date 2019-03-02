package semestr3.Lab5;

import javax.swing.*;
import java.awt.*;

public class Picture extends JFrame {
    JLabel panel = new JLabel();

    public Picture(){
        add(panel);
        panel.setIcon(new ImageIcon("C:\\Users\\Aver\\Desktop\\307600.jpg"));
    }
}
