package semestr4.pr2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Interface extends JFrame {
    JTextArea massiv = new JTextArea("");
    JTextField res = new JTextField("");
    JTextField actionSize = new JTextField("");
    JTextField desired = new JTextField("");
    JButton kmp = new JButton("Метод Кнута, Мориса и Пратта");
    JButton bm = new JButton("Метод Боуэра и Мура");
    JButton sravneniekmp = new JButton("Сравнение перебора с методом КМП");
    JButton sravneniebm = new JButton("Сравнение перебора с методом БМ");
    JButton bmkmp = new JButton("Метод КМП и БМ");
    JButton actionClear = new JButton("Очистить");
    JButton actionRandom = new JButton("Случайно");
    JPanel panel = new JPanel();
    JPanel text = new JPanel();
    JPanel buttons = new JPanel();
    JPanel action = new JPanel();

    GridBagConstraints bag = new GridBagConstraints();
    eHandler handler = new eHandler();


    public Interface(){
        setLayout(new FlowLayout());
        add(panel);

        panel.setLayout(new FlowLayout());
        panel.add(text);
        panel.add(buttons);

        text.setLayout(new GridBagLayout());

        massiv.setRows(27);
        massiv.setColumns(50);
        massiv.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(massiv);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        bag.fill = GridBagConstraints.HORIZONTAL;
        bag.gridy = 0;
        text.add(scroll, bag);

        bag.gridy = 1;
        text.add(action, bag);

        bag.gridy = 2;
        text.add(res, bag);

        buttons.setLayout(new GridBagLayout());

        bag.gridy = 0;
        buttons.add(kmp, bag);

        bag.gridy = 1;
        buttons.add(bm, bag);

        bag.gridy = 2;
        buttons.add(sravneniekmp, bag);

        bag.gridy = 3;
        buttons.add(sravneniebm, bag);

        bag.gridy = 4;
        buttons.add(bmkmp, bag);

        bag.gridy = 5;
        buttons.add(desired, bag);

        action.setLayout(new GridBagLayout());


        bag.fill = GridBagConstraints.VERTICAL;
        bag.gridx = 0;
        bag.gridy = 0;
        action.add(actionSize, bag);
        actionSize.setColumns(20);

        bag.gridx = 2;
        bag.gridy = 0;
        action.add(actionClear, bag);

        bag.gridx = 1;
        bag.gridy = 0;
        action.add(actionRandom, bag);


        Font font = new Font("TimesRoman",Font.BOLD,14);
        massiv.setFont(font);
        res.setFont(font);
        desired.setFont(font);
        kmp.addActionListener(handler);
        bm.addActionListener(handler);
        sravneniekmp.addActionListener(handler);
        sravneniebm.addActionListener(handler);
        bmkmp.addActionListener(handler);
        actionClear.addActionListener(handler);
        actionRandom.addActionListener(handler);
    }
    public void test(){
        while (true){
            kmp.doClick();
        }
    }


    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ((e.getSource() == actionRandom) && !actionSize.getText().trim().isEmpty() && (Integer.parseInt(actionSize.getText()) > 0)){
                RandomString string = new RandomString(Integer.parseInt(actionSize.getText()));
                massiv.setText(string.nextString() + "\n");
            }
            if ((e.getSource() == actionRandom) && actionSize.getText().trim().isEmpty()){
                RandomString string = new RandomString();
                massiv.setText(string.nextString() + "\n");
            }
            if (e.getSource() == actionClear){
                massiv.setText(null);
            }
            if ((e.getSource() == kmp) && !desired.getText().trim().isEmpty()){
                int f = methodKMP(massiv.getText(), desired.getText());
                if (f != 0) {
                    res.setText("Yes - " + f);
                }
                else
                    res.setText("No");
            }
            if ((e.getSource() == kmp) && desired.getText().trim().isEmpty()){
                long sumKMP = 0;
                int maxKMP = 0;
                for (int i = 0; i < massiv.getText().length(); i++) {
                    for (int j = i + 1; j < massiv.getText().length(); j++) {
                        int k = methodKMP(massiv.getText(), massiv.getText().substring(i, j));
                        sumKMP += k;
                        maxKMP = Math.max(maxKMP, k);
                    }
                }
                double sredsumKMP = (double) ((double)(sumKMP * 2 / massiv.getText().length()) / (massiv.getText().length() - 1));
                res.setText(sredsumKMP + " " + maxKMP);
            }
            if ((e.getSource() == bm) && !desired.getText().trim().isEmpty()){

                int f = methodBM(massiv.getText(), desired.getText());
                if (f != 0) {
                    res.setText("Yes - " + f);
                }
                else
                    res.setText("No");
            }
            if ((e.getSource() == bm) && desired.getText().trim().isEmpty()){
                long sumBM = 0;
                int maxBM = 0;
                for (int i = 0; i < massiv.getText().length(); i++) {
                    for (int j = i + 1; j < massiv.getText().length(); j++) {
                        int k  = methodBM(massiv.getText(), massiv.getText().substring(i, j));
                        sumBM += k;
                        maxBM = Math.max(maxBM, k);
                    }
                }
                double sredsumBM = (double) ((double)(sumBM * 2 / massiv.getText().length()) / (massiv.getText().length() - 1));
                res.setText(sredsumBM + " " + maxBM);
            }
            if ((e.getSource() == sravneniekmp) && !desired.getText().trim().isEmpty()){
                int fPerebor = methodPerebor(massiv.getText(), desired.getText());
                int fKMP = methodKMP(massiv.getText(), desired.getText());
                if (fPerebor != 0) {
                    res.setText("Yes - " + fPerebor + " vs " + fKMP);
                }
                else
                    res.setText("No");
            }
            if ((e.getSource() == sravneniekmp) && desired.getText().trim().isEmpty()){
                long sumPerebor = 0;
                int maxPerebor = 0;
                long sumKMP = 0;
                int maxKMP = 0;
                for (int i = 0; i < massiv.getText().length(); i++) {
                    for (int j = i + 1; j < massiv.getText().length(); j++) {
                        int k = methodPerebor(massiv.getText(), massiv.getText().substring(i, j));
                        sumPerebor += k;
                        maxPerebor = Math.max(maxPerebor, k);
                        k = methodKMP(massiv.getText(), massiv.getText().substring(i, j));
                        sumKMP += k;
                        maxKMP = Math.max(maxKMP, k);
                    }
                }
                double sredsumPerebor = (double) ((double)(sumPerebor * 2 / massiv.getText().length()) / (massiv.getText().length() - 1));
                double sredsumKMP = (double) ((double)(sumKMP * 2 / massiv.getText().length()) / (massiv.getText().length() - 1));
                massiv.append(sredsumPerebor + " vs " + sredsumKMP + "\n");
                massiv.append(maxPerebor + " vs " + maxKMP + "\n");
            }
            if ((e.getSource() == sravneniebm) && !desired.getText().trim().isEmpty()){
                int fPerebor = methodPerebor(massiv.getText(), desired.getText());
                int fBM = methodBM(massiv.getText(), desired.getText());
                if (fPerebor != 0) {
                    res.setText("Yes - " + fPerebor + " vs " + fBM);
                }
                else
                    res.setText("No");
            }
            if ((e.getSource() == sravneniebm) && desired.getText().trim().isEmpty()){
                long sumPerebor = 0;
                int maxPerebor = 0;
                long sumBM = 0;
                int maxBM = 0;
                for (int i = 0; i < massiv.getText().length(); i++) {
                    for (int j = i + 1; j < massiv.getText().length(); j++) {
                        int k = methodPerebor(massiv.getText(), massiv.getText().substring(i, j));
                        sumPerebor += k;
                        maxPerebor = Math.max(maxPerebor, k);
                        k = methodBM(massiv.getText(), massiv.getText().substring(i, j));
                        sumBM += k;
                        maxBM = Math.max(maxBM, k);
                    }
                }
                double sredsumPerebor = (double) ((double)(sumPerebor * 2 / massiv.getText().length()) / (massiv.getText().length() - 1));
                double sredsumBM = (double) ((double)(sumBM * 2 / massiv.getText().length()) / (massiv.getText().length() - 1));
                massiv.append(sredsumPerebor + " vs " + sredsumBM + "\n");
                massiv.append(maxPerebor + " vs " + maxBM + "\n");
            }
            if ((e.getSource() == bmkmp) && !desired.getText().trim().isEmpty()){

                int f = methodBMplusKMP(massiv.getText(), desired.getText());
                if (f != 0) {
                    res.setText("Yes - " + f);
                }
                else
                    res.setText("No");
            }
            if ((e.getSource() == bmkmp) && desired.getText().trim().isEmpty()){
                long sumBMKMP = 0;
                int maxBMKMP = 0;
                for (int i = 0; i < massiv.getText().length(); i++) {
                    for (int j = i + 1; j < massiv.getText().length(); j++) {
                        int k  = methodBMplusKMP(massiv.getText(), massiv.getText().substring(i, j));
                        sumBMKMP += k;
                        maxBMKMP = Math.max(maxBMKMP, k);
                    }
                }
                double sredsumBMKMP = (double) ((double)(sumBMKMP * 2 / massiv.getText().length()) / (massiv.getText().length() - 1));
                res.setText(sredsumBMKMP + " " + maxBMKMP);
            }
        }
    }

    public int methodKMP(String massiv, String obraz){
        int pi[] = new int[obraz.length()];
        pi[0] = 0;
        int j = 0;
        int i = 1;
        while ((i < obraz.length()) && (j < obraz.length())){
            if (obraz.charAt(i) == obraz.charAt(j)){
                pi[i] = j + 1;
                i++;
                j++;
            }
            else if (j == 0){
                pi[i] = 0;
                i++;
            }
            else {
                j = pi[j - 1];
            }
        }

        int k = 0;
        int l = 0;
        int count = 0;

        while ((k < massiv.length()) && (l < obraz.length())){
            count++;
            if (massiv.charAt(k) == obraz.charAt(l)){
                if (l == obraz.length() - 1) return count;
                k++;
                l++;
            }
            else if (l == 0){
                if (k == massiv.length() - 1) return 0;
                k++;
            }
            else l = pi[l - 1];
        }
        return -1;
    }

    public int methodBMplusKMP(String massiv, String obraz) {
        int pi[] = new int[256];
        for (int i = 0; i < 256; i++) {
            pi[i] = obraz.length();
        }

        for (int i = obraz.length() - 2; i >= 0; i--) {
            if (pi[(int) obraz.charAt(i)] == obraz.length()){
                pi[(int) obraz.charAt(i)] = obraz.length() - i - 1;
            }
        }


        int i = obraz.length() - 1;
        int j = i;
        int count = 0;

        while (i < massiv.length() && j >= 0){
            count++;
            if (massiv.charAt(i) != obraz.charAt(j)){
                if (j == obraz.length() - 1){
                    i += pi[(int) massiv.charAt(i)];
                }
                else {
                    i += pi[(int) obraz.charAt(obraz.length() - 1)] + obraz.length() - j - 1;
                    j = obraz.length() - 1;
                }
            }
            else {
                if (j == 0) return (int)(count * 0.8947);
                i--;
                j--;
            }
        }
        return 0;
    }

    public int methodBM(String massiv, String obraz) {
        int pi[] = new int[256];
        for (int i = 0; i < 256; i++) {
            pi[i] = obraz.length();
        }

        for (int i = obraz.length() - 2; i >= 0; i--) {
            if (pi[(int) obraz.charAt(i)] == obraz.length()){
                pi[(int) obraz.charAt(i)] = obraz.length() - i - 1;
            }
        }


        int i = obraz.length() - 1;
        int j = i;
        int count = 0;

        while (i < massiv.length() && j >= 0){
            count++;
            if (massiv.charAt(i) != obraz.charAt(j)){
                if (j == obraz.length() - 1){
                    i += pi[(int) massiv.charAt(i)];
                }
                else {
                    i += pi[(int) obraz.charAt(obraz.length() - 1)] + obraz.length() - j - 1;
                    j = obraz.length() - 1;
                }
            }
            else {
                if (j == 0) return count;
                i--;
                j--;
            }
        }
        return 0;
    }

    public int  methodPerebor(String massiv, String obraz){
        int i = 0;
        int j = 0;
        int count = 0;
        int countSrav = 0;

        while (i < massiv.length() && j < obraz.length()){
            count++;
            if (massiv.charAt(i) == obraz.charAt(j)){
                if (j == obraz.length() - 1) return count;
                i++;
                j++;
                countSrav++;
            }
            else {
                i -= countSrav - 1;
                j = 0;
                countSrav = 0;
            }
        }
        return 0;
    }
}
