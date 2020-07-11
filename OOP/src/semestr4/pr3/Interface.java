package semestr4.pr3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Interface extends JFrame {
    JTextArea massiv = new JTextArea("");
    JTextArea massivSort = new JTextArea("");
    JTextField actionSize = new JTextField("");
    JButton directEnable = new JButton("Сортировка прямого включения");
    JButton binaryEnable = new JButton("Сортировка двоичного включения");
    JButton directSelection = new JButton("Сортировка прямого выбора");
    JButton shaker = new JButton("Шейкерная сортировка");
    JButton shella = new JButton("Сортировка Шелла");
    JButton srav = new JButton("Сравнение");
    JButton actionClear = new JButton("Очистить");
    JButton actionRandom = new JButton("Случайно");
    JPanel panel = new JPanel();
    JPanel text = new JPanel();
    JPanel buttons = new JPanel();
    JPanel action = new JPanel();

    //ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<Integer> numbersSort = new ArrayList<>();

    GridBagConstraints bag = new GridBagConstraints();
    eHandler handler = new eHandler();


    public Interface(){
        setLayout(new FlowLayout());
        add(panel);

        panel.setLayout(new FlowLayout());
        panel.add(text);
        panel.add(buttons);

        text.setLayout(new GridBagLayout());

        massiv.setRows(16);
        massiv.setColumns(50);
        massiv.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(massiv);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        massivSort.setRows(16);
        massivSort.setColumns(50);
        massivSort.setLineWrap(true);
        JScrollPane scrollSort = new JScrollPane(massivSort);
        scrollSort.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        bag.fill = GridBagConstraints.HORIZONTAL;
        bag.gridy = 0;
        text.add(scroll, bag);

        bag.gridy = 1;
        text.add(action, bag);

        bag.gridy = 2;
        text.add(scrollSort, bag);

        buttons.setLayout(new GridBagLayout());

        bag.gridy = 0;
        buttons.add(directEnable, bag);

        bag.gridy = 1;
        buttons.add(binaryEnable, bag);

        bag.gridy = 2;
        buttons.add(directSelection, bag);

        bag.gridy = 3;
        buttons.add(shaker, bag);

        bag.gridy = 4;
        buttons.add(shella, bag);

        bag.gridy = 5;
        buttons.add(srav, bag);

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
        massivSort.setFont(font);
        directEnable.addActionListener(handler);
        binaryEnable.addActionListener(handler);
        directSelection.addActionListener(handler);
        shaker.addActionListener(handler);
        shella.addActionListener(handler);
        srav.addActionListener(handler);
        actionClear.addActionListener(handler);
        actionRandom.addActionListener(handler);
    }
    public void test(){
        while (true){
            directEnable.doClick();
        }
    }


    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ((e.getSource() == actionRandom) && !actionSize.getText().trim().isEmpty() && (Integer.parseInt(actionSize.getText()) > 0)){
                massiv.setText(null);

                Random random = new Random();
                for (int i = 0; i < Integer.parseInt(actionSize.getText()); i++) {
                    int temp =random.nextInt(Integer.parseInt(actionSize.getText()) + 1);
                    massiv.append(temp + " ");
                }
            }
            if ((e.getSource() == actionRandom) && actionSize.getText().trim().isEmpty()){
                massiv.setText(null);

                Random random = new Random();
                for (int i = 0; i < 50; i++) {
                    int temp =random.nextInt(51);
                    massiv.append(temp + " ");
                }
            }
            if (e.getSource() == actionClear){
                massiv.setText(null);
                massivSort.setText(null);
                numbersSort.clear();
            }
            if (e.getSource() == directEnable){
                numbersSort.clear();
//                numbersSort.addAll(numbers);
                String temp[] = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                int count = SortDirectEnable(numbersSort);
                massivSort.setText(null);

                for (int tempp : numbersSort){
                    massivSort.append(tempp + " ");
                }
                massivSort.append("\n" + Integer.toString(count));
            }
            if (e.getSource() == binaryEnable){
                numbersSort.clear();
                String temp[] = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                int count = SortBinaryEnable(numbersSort);
                massivSort.setText(null);

                for (int tempp : numbersSort){
                    massivSort.append(tempp + " ");
                }
                massivSort.append("\n" + Integer.toString(count));
            }
            if (e.getSource() == directSelection){
                numbersSort.clear();
                String temp[] = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                int count = SortDirectSelection(numbersSort);
                massivSort.setText(null);

                for (int tempp : numbersSort){
                    massivSort.append(tempp + " ");
                }
                massivSort.append("\n" + Integer.toString(count));
            }
            if (e.getSource() == shaker){
                numbersSort.clear();
                String temp[] = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                int count = SortShaker(numbersSort);
                massivSort.setText(null);

                for (int tempp : numbersSort){
                    massivSort.append(tempp + " ");
                }
                massivSort.append("\n" + Integer.toString(count));
            }
            if (e.getSource() == shella){
                numbersSort.clear();
                String temp[] = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                int count = SortShella(numbersSort);
                massivSort.setText(null);

                for (int tempp : numbersSort){
                    massivSort.append(tempp + " ");
                }
                massivSort.append("\n" + Integer.toString(count));
            }
            if (e.getSource() == srav){
                massivSort.setText(null);

                numbersSort.clear();
                String temp[] = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                int count = SortDirectEnable(numbersSort);
                massivSort.append("Сортировка прямого включения - " + Integer.toString(count));

                numbersSort.clear();
                temp = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                count = SortBinaryEnable(numbersSort);
                massivSort.append("\n" + "Сортировка двоичного включения - "+ Integer.toString(count));

                numbersSort.clear();
                temp = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                count = SortDirectSelection(numbersSort);
                massivSort.append("\n" + "Сортировка прямого выбора - " + Integer.toString(count));

                numbersSort.clear();
                temp = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                count = SortShaker(numbersSort);
                massivSort.append("\n" + "Шейкерная сортировка - " + Integer.toString(count));

                numbersSort.clear();
                temp = massiv.getText().split(" ");
                for (String s : temp){
                    numbersSort.add(Integer.parseInt(s));
                }
                count = SortShella(numbersSort);
                massivSort.append("\n" + "Сортировка Шелла - " + Integer.toString(count));
            }
        }
    }


    public int SortDirectEnable(ArrayList<Integer> number){
        int temp, j;
        int count = 0;
        for(int i = 0; i < number.size() - 1; i++){
            if (number.get(i) > number.get(i + 1)) {
                temp = number.get(i + 1);
                number.set(i + 1, number.get(i));
                j = i;
                while (j > 0 && temp < number.get(j - 1)) {
                    number.set(j, number.get(j - 1));
                    j--;
                    count++;
                }
                number.set(j, temp);
            }
        }
        return count;
    }
    public int SortBinaryEnable(ArrayList<Integer> number){
        int temp, j;
        int count = 0;
        for(int i = 0; i < number.size() - 1; i++){
            if (number.get(i) > number.get(i + 1)) {
                temp = number.get(i + 1);
                number.set(i + 1, number.get(i));
                j = searhBinary(temp, i, number, count);
                for (int k = i; k > j; k--) {
                    number.set(k, number.get(k - 1));
                }
                int n = number.size();
                count += (int) Math.log(n);
                number.set(j, temp);
            }
        }
        return count;
    }
    public int SortDirectSelection(ArrayList<Integer> number){
        int count = 0;
        for (int min = 0; min < number.size() - 1; min++) {
            int least = min;
            for (int j = min + 1; j < number.size(); j++) {
                if (number.get(j) < number.get(least)) {
                    least = j;
                    count++;
                }
            }
            int temp = number.get(min);
            number.set(min, number.get(least));
            number.set(least, temp);
        }
        return count;
    }
    public int SortShaker(ArrayList<Integer> number){
        int temp;
        int count = 0;
        int left = 0;
        int right = number.size()-1;
        do {
            for (int i = left; i < right; i++) {
                if (number.get(i) > number.get(i + 1)) {
                    temp = number.get(i);
                    number.set(i, number.get(i + 1));
                    number.set(i + 1, temp);
                    count++;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (number.get(i) < number.get(i - 1)) {
                    temp = number.get(i);
                    number.set(i, number.get(i - 1));
                    number.set(i - 1, temp);
                    //count++;
                }
            }
            left++;
        } while (left < right);
        return count;
    }
    public int SortShella(ArrayList<Integer> number){
        int count = 0;
        int increment = number.size() / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                count += insertionSort(number, startIndex, increment);
            }
            increment = increment / 2;
        }
        return count;
    }
    public int insertionSort (ArrayList<Integer> number, int startIndex, int increment) {
        int count = 0;
        for (int i = startIndex; i < number.size() - 1; i = i + increment) {
            for (int j = Math.min(i + increment, number.size() - 1); j - increment >= 0; j = j - increment) {
                if (number.get(j - increment) > number.get(j)) {
                    int temp = number.get(j);
                    number.set(j, number.get(j - increment));
                    number.set(j - increment, temp);
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int searhBinary(int search, int Rp, ArrayList<Integer> number, int count){
        int L = -1;
        int R = Rp;
        int k = 0;
        int n = 0;

        while ((R - L) > 1) {
            //srav++;
            k = (L + R) / 2;  //1 0 1 6 5 1 3 3 1 10
            if (number.get(k) >= search) {
                R = k;
            }
            else if (number.get(k) < search) {
                L = k;
            }
            n++;
        }
        count += n;
        return R;
    }
}
