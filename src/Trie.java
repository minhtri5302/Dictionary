public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    TrieNode getRoot() {
        return root;
    }
    public void insert(String s){
        TrieNode curNode = root;
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (curNode.child[index] == null)
                curNode.child[index] = new TrieNode();
            curNode = curNode.child[index];
        }
        curNode.isEndOfWord = true;
    }

    public boolean search(String s) {
        TrieNode curNode = root;
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (curNode.child[index] == null)
                return false;
            curNode = curNode.child[index];
        }
        return curNode.isEndOfWord;
    }

    public boolean isEmptyRoot(TrieNode curRoot) {
        for (int i = 0; i < 26; ++i) {
            if(curRoot.child[i] != null) {
                return false;
            }
        }
        return true;
    }

    public TrieNode delete(TrieNode curRoot , String s, int depth) {
        if(curRoot == null) {
            return null;
        }
        if(depth == s.length()) {
            if (curRoot.isEndOfWord) {
                curRoot.isEndOfWord = false;
            }
            if(isEmptyRoot(curRoot)) {
                curRoot = null;
            }
            return curRoot;
        }

        int index = s.charAt(depth) - 'a';
        curRoot.child[index] = delete(curRoot.child[index], s, depth + 1);
        if (isEmptyRoot(curRoot) && !curRoot.isEndOfWord){
            curRoot = null;
        }
        return curRoot;
    }
}
