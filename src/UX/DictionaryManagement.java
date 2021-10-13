package UX;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

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
                if (inputStr[0].equals("")) continue;
                if (!dictionary.getWordList().containsKey(inputStr[0]))
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

    public String searchWord(String target) {
        if (target.equals("")) return "Hãy nhập từ cần tìm";
        if (!dictionary.getWordList().containsKey(target)) return "Không tìm thấy từ này trong từ điển";
        HashMap<String, String> wordList = dictionary.getWordList();
        return wordList.get(target);
    }

    public boolean addWord(String target, String explain) {
        if (target.equals("") || explain.equals("") || dictionary.getWordList().containsKey(target)) return false;
        dictionary.addWord(target, explain);
        dictionaryExportToFile();
        return true;
    }

    public boolean deleteWord(String target) {
        if (target.equals("") || !dictionary.getWordList().containsKey(target)) return false;
        dictionary.deleteWord(target);
        dictionaryExportToFile();
        return true;
    }

    public boolean editWord(String target, String explain) {
        if (target.equals("") || explain.equals("") || !dictionary.getWordList().containsKey(target)) return false;
        dictionary.editWord(target, explain);
        dictionaryExportToFile();
        return true;
    }

    public boolean userAddWord() {
        System.out.println("Nhập từ muốn thêm vào từ điển:");
        String target, explain;
        while (true) {
            target = sc.nextLine();
            if (!target.equals("")) break;
        }
        target = target.toLowerCase();
        if (!dictionary.getWordList().containsKey(target)) {
            System.out.println("Nhập nghĩa của từ trên:");
            while (true) {
                explain = sc.nextLine();
                if (!explain.equals("")) break;
            }
            explain = explain.toLowerCase();
            dictionary.addWord(target, explain);
            dictionaryExportToFile();
            return true;
        } else {
            System.out.println("Từ này đã có trong từ điển!");
            return false;
        }
    }

    public boolean userDeleteWord() {
        System.out.println("Nhập từ muốn xoá khỏi từ điển:");
        String target;
        while (true) {
            target = sc.nextLine();
            if (!target.equals("")) break;
        }
        target = target.toLowerCase();
        if (dictionary.getWordList().containsKey(target)) {
            dictionary.deleteWord(target);
            dictionaryExportToFile();
            return true;
        } else {
            System.out.println("Từ này chưa có trong từ điển");
            return false;
        }
    }

    public boolean userEditWord() {
        System.out.println("Nhập từ muốn sửa trong từ điển:");
        String target, explain;
        while (true) {
            target = sc.nextLine();
            if (!target.equals("")) break;
        }
        target = target.toLowerCase();
        if (dictionary.getWordList().containsKey(target)) {
            System.out.println("Nhập nghĩa của từ trên:");
            while (true) {
                explain = sc.nextLine();
                if (!explain.equals("")) break;
            }
            explain = explain.toLowerCase();
            dictionary.editWord(target, explain);
            dictionaryExportToFile();
            return true;
        } else {
            System.out.println("Từ này chưa có trong từ điển");
            return false;
        }
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
