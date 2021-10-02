import java.util.HashMap;
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
        int numWord = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numWord; i++) {
            String a = sc.nextLine();
            String[] inputStr = a.split(" ", 2);
            dictionary.addWord(inputStr[0], inputStr[1]);
        }
    }

    void insertFromFile() {
        try {
            String inp_url = "dictionaries.txt";
            File myFile = new File(inp_url);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String[] inputStr = myReader.nextLine().split(" ", 2);
                dictionary.addWord(inputStr[0], inputStr[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not founded.");
            e.printStackTrace();
        }
    }

    public void dictionaryLookup() {
        while (sc.hasNextLine()) {
            String findExplain = sc.nextLine();
            HashMap<String, String> wordList = dictionary.getWordList();
            System.out.println(wordList.getOrDefault(findExplain, "Don't find word what you need :("));

        }
    }
}
