package semestr3.Lab8;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Aver\\IdeaProjects\\OOP\\src\\Lab8\\text.txt");
        FileWriter fileWriter = new FileWriter(file);
        FileReader fileReader = new FileReader(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedWriter.write("1");
        bufferedWriter.newLine();
        bufferedWriter.write("2");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();

        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }

    }
}
