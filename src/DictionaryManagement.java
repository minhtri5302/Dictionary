import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary s = new Dictionary();
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; ++i)
        {
            String a = sc.nextLine();
            String b = sc.nextLine();
            s.a[i] = new Word(a, b);
        }
    }
}
