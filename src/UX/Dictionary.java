package UX;

import java.util.HashMap;

public class Dictionary {
    private int numWord;
    private HashMap<String, String> wordList = new HashMap<>();
    private Trie trie = new Trie();

    public HashMap<String, String> getWordList() {
        return wordList;
    }

    public void addWord(String target, String explain) {
        target = target.toLowerCase();
        wordList.put(target, explain);
        trie.insert(target);
    }

    public void deleteWord(String target) {
        target = target.toLowerCase();
        wordList.remove(target);
        trie.delete(trie.getRoot(), target, 0);
    }

    public void editWord(String target, String explain) {
        target = target.toLowerCase();
        wordList.replace(target, explain);
    }
}
