package semestr3.test.Test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame
{
    JTextField textField = new JTextField(); // текстовое поле общее для всего класса
    public Main()
    {
        super("URL");
        createGUI();
    }
    public void createGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // выход из окна с помощью крестика

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("enter URL:");

        JButton button = new JButton("ENTER");

        label.setVerticalAlignment(label.CENTER);
        label.setHorizontalAlignment(label.CENTER);

        textField.setColumns(23);

        panel.add(label); // добавление на панель всех компанентов
        panel.add(textField);
        panel.add(button);

        getContentPane().add(panel);

        ActionListener actionListener = new TestActionListener();
        KeyListener keyListener = new TestKeyListener();

        button.addActionListener(actionListener);  // привязка к кнопке действие поиска
        textField.addKeyListener(keyListener);  // привязка к клавише enter действие поиска

        setPreferredSize(new Dimension(300,200));
    }
    public class TestActionListener implements ActionListener //при нажатии на кнопку будет начинаться поиск ссылки
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String name = textField.getText();
            BrowserOpener opener = new BrowserOpener();
            opener.openLinkInBrowser(name);
        }
    }
    public class TestKeyListener extends KeyAdapter // при нажатии на enter будет происходить поиск
    {
        @Override
        public void keyReleased(KeyEvent e)
        {
            if(e.getKeyChar() == KeyEvent.VK_ENTER)
            {
                String name = textField.getText();
                BrowserOpener opener = new BrowserOpener();
                opener.openLinkInBrowser(name);
            }
        }
    }
    public static void main(String[] args)
    {
        Main main = new Main();
        main.pack();
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }
}