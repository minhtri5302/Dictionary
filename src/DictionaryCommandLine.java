import java.util.HashMap;

public class DictionaryCommandLine {
    private DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void showAllWords() {
        Dictionary dictionary = dictionaryManagement.getDictionary();
        System.out.format("%-5s%-20s%-20s\n", "No", "|English", "|Vietnamese");
        HashMap<String, String> wordList = dictionary.getWordList();
        int i = 0;
        for (String s : wordList.keySet()) {
            System.out.format("%-5s%-20s%-20s\n", ++i, s, wordList.get(s));
        }
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile();
        showAllWords();
        dictionaryManagement.dictionaryLookup();
    }

    public static void main(String[] args) {
        DictionaryCommandLine p = new DictionaryCommandLine();
        p.dictionaryAdvanced();
        while (true) {
            p.dictionaryManagement.userAddWord();
            p.dictionaryManagement.userDeleteWord();
            p.dictionaryManagement.userEditWord();
            p.dictionaryAdvanced();
        }
    }
}
