package semestr3.Pr6;
//Comparable
//Лафорэ алгоритмы и структуры данных
//Гудрич Тамасся алгоритмы и структуры данных
import java.util.ArrayList;

public class Test {
    protected ArrayList<Student> s = new ArrayList<Student>();

    public Test() {
    }
    public void Add(Student student){
        s.add(student);
    }

    public void Add(String str, int n){
        Student student = new Student(str,n);
        s.add(student);
    }

    public void SortRating(){
        int startIndex = 0;
        int endIndex = s.size() - 1;
        doSortRating(startIndex, endIndex);
    }
    public void doSortRating(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (s.get(i).getRating() <= s.get(cur).getRating())) {
                i++;
            }
            while (j > cur && (s.get(cur).getRating() <= s.get(j).getRating())) {
                j--;
            }
            if (i < j) {
                Student temp = s.get(i);
                s.set(i,s.get(j));
                s.set(j,temp);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortRating(start, cur);
        doSortRating(cur+1, end);
    }
    public void SortName(){
        int startIndex = 0;
        int endIndex = s.size() - 1;
        doSortName(startIndex, endIndex);
    }

    public void doSortName(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (s.get(i).getName().compareTo(s.get(cur).getName()) <= 0)) {
                i++;
            }
            while (j > cur && (s.get(cur).getName().compareTo(s.get(j).getName()) <= 0)) {
                j--;
            }
            if (i < j) {
                Student temp = s.get(i);
                s.set(i,s.get(j));
                s.set(j,temp);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortName(start, cur);
        doSortName(cur+1, end);
    }

    public void sout() {
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i).getName() + " " + s.get(i).getRating());
        }
        System.out.println();
    }
}
