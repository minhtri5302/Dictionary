import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();
    private Scanner sc = new Scanner(System.in);
    public Dictionary getDictionary() {
        return dictionary;
    }

    public void insertFromCommandline() {
        dictionary.setNumWord(Integer.parseInt(sc.nextLine()));
        for (int i = 0; i < dictionary.getNumWord(); i++) {
            String a = sc.nextLine();
            String[] inputStr = a.split(" ", 2);
            dictionary.wordList[i] = new Word(inputStr[0], inputStr[1]);
        }
    }

    void insertFromFile() {
        try {
            String inp_url = "dictionaries.txt";
            File myFile = new File(inp_url);
            Scanner myReader = new Scanner(myFile);
            int cnt = 0;
            while (myReader.hasNextLine() && cnt < 100) {
                String[] inputStr = myReader.nextLine().split(" ", 2);
                dictionary.wordList[cnt++] = new Word(inputStr[0], inputStr[1]);
            }
            dictionary.setNumWord(cnt);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not founded.");
            e.printStackTrace();
        }
    }

    public void dictionaryLookup() {
        while (sc.hasNextLine()) {
            String findExplain = sc.nextLine();
            boolean ok = false;
            for (int i = 0; i < dictionary.getNumWord(); ++i) {
                if (findExplain.equals(dictionary.wordList[i].getWord_target())) {
                    System.out.println(dictionary.wordList[i].getWord_explain());
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                System.out.println("Don't find word what you need :(");
            }
        }
    }
}
