import java.util.HashMap;

public class Dictionary {
    private int numWord;
    private HashMap<String, String> wordList = new HashMap<>();

    public HashMap<String, String> getWordList() {
        return wordList;
    }

    public void addWord(String target, String explain) {
        wordList.put(target, explain);
    }
}
