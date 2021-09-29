import java.util.Scanner;

public class DictionaryManagement {
    Dictionary s = new Dictionary();
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        s.so_tu = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= s.so_tu; ++i)
        {
            String a = sc.nextLine();
            String b = sc.nextLine();
            s.a[i] = new Word(a, b);
        }
    }
}
