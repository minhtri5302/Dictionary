package UX;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void insertFromFile() {
        try {
            String inp_url = "dictionaries.txt";
            File myFile = new File(inp_url);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String[] inputStr = myReader.nextLine().split("#");
                if (inputStr[0].equals("")) continue;
                String explain = "";
                for (int i = 1; i < inputStr.length; ++i) {
                    explain += inputStr[i] + "\n";
                }
                if (!dictionary.getWordList().containsKey(inputStr[0]))
                    dictionary.addWord(inputStr[0], explain);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not founded.");
            e.printStackTrace();
        }
    }

    public String searchWord(String target) {
        if (target.equals(""))
            return "Hãy nhập từ cần tìm";
        if (!dictionary.getWordList().containsKey(target)) return "Không tìm thấy từ này trong từ điển";
        HashMap<String, String> wordList = dictionary.getWordList();
        return wordList.get(target);
    }

    public boolean addWord(String target, String explain) {
        if (target.equals("") || explain.equals("") || dictionary.getWordList().containsKey(target)) return false;
        dictionary.addWord(target, explain);
        return true;
    }

    public boolean deleteWord(String target) {
        if (target.equals("") || !dictionary.getWordList().containsKey(target)) return false;
        dictionary.deleteWord(target);
        return true;
    }

    public boolean editWord(String target, String explain) {
        if (target.equals("") || explain.equals("") || !dictionary.getWordList().containsKey(target)) return false;
        dictionary.editWord(target, explain);
        return true;
    }

    public void dictionaryExportToFile() {
        try {
            FileWriter fileWriter = new FileWriter("dictionaries.txt");
            HashMap<String, String> wordList = dictionary.getWordList();
            for (String s : wordList.keySet()) {
                fileWriter.write(s + " " + wordList.get(s) + "\n");
            }
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
