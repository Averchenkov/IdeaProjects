package semestr4.pr1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

interface Operation{
    int execute(int L, int R);
}

public class Interface extends JFrame {
    JTextArea massiv = new JTextArea("");
    JTextField res = new JTextField("");
    JTextField addName = new JTextField("");
    JTextField addHeight = new JTextField("");
    JTextField desired = new JTextField("");
    JButton perebor = new JButton("Перебор");
    JButton barer = new JButton("Перебор с барьером");
    JButton sravneniepb = new JButton("Сравнение перебора с барьером и без");
    JButton binary = new JButton("Бинарный поиск");
    JButton gold = new JButton("Бинарный поиск с золотым сечением");
    JButton sravnennie = new JButton("Сравнение всех сортировок");
    JButton actionAdd = new JButton("Добавить");
    JButton actionClear = new JButton("Очистить");
    JButton actionRandom = new JButton("Случайно");
    JPanel panel = new JPanel();
    JPanel text = new JPanel();
    JPanel buttons = new JPanel();
    JPanel action = new JPanel();

    Mount[] mounts = new Mount[1000];
    int countMounts = 0;
    GridBagConstraints bag = new GridBagConstraints();
    eHandler handler = new eHandler();


    public Interface(){
        setLayout(new FlowLayout());
        add(panel);

        panel.setLayout(new FlowLayout());
        panel.add(text);
        panel.add(buttons);

        text.setLayout(new GridBagLayout());

        bag.fill = GridBagConstraints.HORIZONTAL;
        bag.gridy = 0;
        text.add(massiv, bag);
        massiv.setRows(27);
        massiv.setColumns(50);

        bag.gridy = 1;
        text.add(action, bag);

        bag.gridy = 2;
        text.add(res, bag);

        buttons.setLayout(new GridBagLayout());

        bag.gridy = 0;
        buttons.add(perebor, bag);

        bag.gridy = 1;
        buttons.add(barer, bag);

        bag.gridy = 2;
        buttons.add(sravneniepb, bag);

        bag.gridy = 3;
        buttons.add(binary, bag);

        bag.gridy = 4;
        buttons.add(gold, bag);

        bag.gridy = 5;
        buttons.add(sravnennie, bag);

        bag.gridy = 6;
        buttons.add(desired, bag);

        action.setLayout(new GridBagLayout());


        bag.fill = GridBagConstraints.VERTICAL;
        bag.gridx = 0;
        bag.gridy = 0;
        action.add(addName, bag);
        addName.setColumns(20);

        bag.gridx = 0;
        bag.gridy = 1;
        action.add(addHeight, bag);
        addHeight.setColumns(20);

        bag.gridx = 1;
        bag.gridy = 0;
        action.add(actionAdd, bag);

        bag.gridx = 2;
        bag.gridy = 0;
        action.add(actionClear, bag);

        bag.gridx = 1;
        bag.gridy = 1;
        action.add(actionRandom, bag);


        Font font = new Font("TimesRoman",Font.BOLD,14);
        massiv.setFont(font);
        res.setFont(font);
        desired.setFont(font);
        perebor.addActionListener(handler);
        barer.addActionListener(handler);
        sravneniepb.addActionListener(handler);
        binary.addActionListener(handler);
        gold.addActionListener(handler);
        sravnennie.addActionListener(handler);
        actionAdd.addActionListener(handler);
        actionClear.addActionListener(handler);
        actionRandom.addActionListener(handler);
    }

    public int searhPerebor(int x){
        int srav = 0;
        boolean f = false;

        for (int i = 0; i < countMounts; i++) {
            if (mounts[i].getHeight() == x)
                f = true;
            srav++;
        }
        if (f)
            return srav;
        else
            return 0;
    }

    public int searhBarer(int x){
        int srav = 1;
        Mount last = mounts[countMounts - 1];
        int i;
        for (i = 0; mounts[i].getHeight() != x; i++) {
            srav++;
        }
        mounts[countMounts - 1] = last;
        if ((i != countMounts - 1) || (x == last.getHeight()))
            return srav;
        else
            return 0;
    }


    public int searhBinary(Operation mid, int search){
        int srav = 0;

        Mount copy[] = new Mount[countMounts];
        for (int i = 0; i < countMounts; i++) {
            copy[i] = mounts[i];
        }

        SortMounts(copy);

        int nX = -1;
        int L = 0;
        int R = countMounts - 1;
        for (int j = 0; j < countMounts; j++) {
            while (L <= R) {
                srav++;
                int k = mid.execute(L, R);
                if (copy[k].getHeight() == search) {
                    nX = copy[k].getHeight();
                    return srav;
                }
                else if (copy[k].getHeight() > search) {
                    R = k - 1;
                }
                else if (copy[k].getHeight() < search) {
                    L = k + 1;
                }
            }
        }
        return 0;
    }

    public static Operation midBinary(){
        return (L, R) -> (L + R) / 2;
    }

    public static Operation midBinaryGold(){
        return (L, R) -> (int) Math.round(L + (2 / (Math.sqrt(5) + 1)) * (R - L));
    }

    public void SortMounts(Mount[] mounts){
        int startIndex = 0;
        int endIndex = countMounts - 1;
        doSortMouns(mounts, startIndex, endIndex);
    }

    public void doSortMouns(Mount[] mounts, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (mounts[i].getHeight() <= mounts[cur].getHeight())) {
                i++;
            }
            while (j > cur && (mounts[cur].getHeight() <= mounts[j].getHeight())) {
                j--;
            }
            if (i < j) {
                Mount temp = mounts[i];
                mounts[i] = mounts[j];
                mounts[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortMouns(mounts, start, cur);
        doSortMouns(mounts, cur+1, end);
    }


    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ((e.getSource() == actionAdd) && !addName.getText().trim().isEmpty() && !addHeight.getText().trim().isEmpty()){
                massiv.append(Integer.toString(countMounts) + " - " + "Гора " + addName.getText() + " с высотой " + addHeight.getText() + "\n");
                mounts[countMounts] = new Mount(Integer.parseInt(addHeight.getText()),addName.getText());
                countMounts++;
            }
            if (e.getSource() == actionRandom){
                RandomString string = new RandomString();
                Random random = new Random();
                mounts[countMounts] = new Mount(1 + random.nextInt(100), string.nextString());
                massiv.append(Integer.toString(countMounts) + " - " + "Гора " + mounts[countMounts].getName() + " с высотой " + Integer.toString(mounts[countMounts].getHeight()) + "\n");
                countMounts++;
            }
            if (e.getSource() == actionClear){
                for (int i = 0; i < countMounts; i++) {
                    mounts[countMounts] = null;
                }
                massiv.setText(null);
                countMounts = 0;
            }
            if ((e.getSource() == perebor) && !desired.getText().trim().isEmpty() && (countMounts > 0)){
                int srav = searhPerebor(Integer.parseInt(desired.getText()));
                if (srav != 0) {
                    res.setText("Yes - " + srav);
                }
                else {
                    res.setText("No");
                }
            }
            if ((e.getSource() == barer) && !desired.getText().trim().isEmpty() && (countMounts > 0)){
                int srav = searhBarer(Integer.parseInt(desired.getText()));
                if (srav != 0) {
                    res.setText("Yes - " + srav);
                }
                else {
                    res.setText("No");
                }
            }
            if ((e.getSource() == binary) && !desired.getText().trim().isEmpty() && (countMounts > 0)){
                int srav = searhBinary(midBinary(),Integer.parseInt(desired.getText()));
                if (srav != 0) {
                    res.setText("Yes - " + srav);
                }
                else {
                    res.setText("No");
                }
            }
            if ((e.getSource() == gold) && !desired.getText().trim().isEmpty() && (countMounts > 0)){
                int srav = searhBinary(midBinaryGold(),Integer.parseInt(desired.getText()));
                if (srav != 0) {
                    res.setText("Yes - " + srav);
                }
                else {
                    res.setText("No");
                }
            }
            if ((e.getSource() == sravneniepb) && (countMounts > 0)){
                double sumPerebor = 0;
                double sumBarer = 0;
                for (int i = 0; i < countMounts; i++) {
                    sumPerebor += (double) searhPerebor(mounts[i].getHeight()) / countMounts;
                    sumBarer += (double) searhBarer(mounts[i].getHeight()) / countMounts;
                }
                massiv.append("\n" + "Количество сравнения для поиска перебором = " + String.valueOf(sumPerebor));
                massiv.append("\n" + "Количество сравнения для поиска перебором с барьером = " + String.valueOf(sumBarer));
            }
            if ((e.getSource() == sravnennie)){
                double sumPerebor = 0;
                double sumBarer = 0;
                double sumBinary = 0;
                double sumBinaryGold = 0;
                for (int i = 0; i < countMounts; i++) {
                    sumPerebor += (double) searhPerebor(mounts[i].getHeight()) / countMounts;
                    sumBarer += (double) searhBarer(mounts[i].getHeight()) / countMounts;
                    sumBinary += (double) searhBinary(midBinary(), mounts[i].getHeight()) / countMounts;
                    sumBinaryGold += (double) searhBinary(midBinaryGold(), mounts[i].getHeight()) / countMounts;
                }
                massiv.append("\n" + "Количество сравнения для поиска перебором = " + String.valueOf(sumPerebor));
                massiv.append("\n" + "Количество сравнения для поиска перебором с барьером= " + String.valueOf(sumBarer));
                massiv.append("\n" + "Количество сравнения для бинарного поиска = " + String.valueOf(sumBinary));
                massiv.append("\n" + "Количество сравнения для бинарного поиска с золотым сечением = " + String.valueOf(sumBinaryGold));
            }
        }
    }
}
