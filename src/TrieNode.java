public class TrieNode {
    public boolean isEndOfWord;
    TrieNode[] child = new TrieNode[26];

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; ++i)
            child[i] = null;
    }
}
