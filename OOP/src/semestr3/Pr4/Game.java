package semestr3.Pr4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    JButton milan = new JButton("AC Milan");
    JButton madrid = new JButton("Real Madrid");
    JLabel result = new JLabel("Result: 0 X 0");
    JLabel last = new JLabel("");
    JLabel winner = new JLabel("");
    int imilan = 0;
    int imadrid = 0;
    eHandler handler = new eHandler();

    public Game(){
        setLayout(new FlowLayout());
        add(milan);
        add(madrid);
        add(result);
        add(last);
        add(winner);
        milan.addActionListener(handler);
        madrid.addActionListener(handler);
    }



    public class eHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == milan){
                imilan++;
                result.setText("Result: " + imilan + " X " + imadrid);
                last.setText("Last Scorer: AC Milan");
                if (imilan == imadrid){
                    winner.setText(null);
                }
                else if (imilan > imadrid){
                    winner.setText("Winner: AC Milan");
                }
                else if (imilan < imadrid){
                    winner.setText("Winner: Real Madrid");
                }
            }
            else if (e.getSource() == madrid){
                imadrid++;
                result.setText("Result: " + imilan + " X " + imadrid);
                last.setText("Last Scorer: Real Madrid");
                if (imilan == imadrid){
                    winner.setText(null);
                }
                else if (imilan > imadrid){
                    winner.setText("Winner: AC Milan");
                }
                else if (imilan < imadrid){
                    winner.setText("Winner: Real Madrid");
                }
            }
        }
    }
}
