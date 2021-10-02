import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dictionary= new Dictionary();
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        dictionary.numWord = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= dictionary.numWord; ++i)
        {
            String a = sc.nextLine();
            String b = sc.nextLine();
            dictionary.wordList[i] = new Word(a, b);
        }
    }
}
