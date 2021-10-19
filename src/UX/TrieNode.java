package UX;

public class TrieNode {
    public boolean isEndOfWord;
    TrieNode[] child = new TrieNode[257];

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 257; ++i)
            child[i] = null;
    }
}
