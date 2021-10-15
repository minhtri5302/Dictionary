package UX;

import java.util.ArrayList;

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    TrieNode getRoot() {
        return root;
    }

    public void insert(String s) {
        TrieNode curNode = root;
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (curNode.child[index] == null)
                curNode.child[index] = new TrieNode();
            curNode = curNode.child[index];
        }
        curNode.isEndOfWord = true;
    }

    public ArrayList<String> search(String s) {
        ArrayList<String> results = new ArrayList<String>();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
                return results;
            }
        }
        TrieNode curNode = root;
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (curNode.child[index] == null)
                return results;
            curNode = curNode.child[index];
        }
        dfsTrie(curNode, results, s);
        return results;
    }

    public void dfsTrie(TrieNode curNode, ArrayList<String> results, String prefix) {
        if (curNode.isEndOfWord) results.add(prefix);
//        if(results.size() >= 15) return;
        for (int i = 0; i < 26; ++i) {
            if (curNode.child[i] != null) {
                dfsTrie(curNode.child[i], results, prefix + (char) (i + (int) 'a'));
            }
        }
    }

    public boolean isEmptyRoot(TrieNode curRoot) {
        for (int i = 0; i < 26; ++i) {
            if (curRoot.child[i] != null) {
                return false;
            }
        }
        return true;
    }

    public TrieNode delete(TrieNode curRoot, String s, int depth) {
        if (curRoot == null) {
            return null;
        }
        if (depth == s.length()) {
            if (curRoot.isEndOfWord) {
                curRoot.isEndOfWord = false;
            }
            if (isEmptyRoot(curRoot)) {
                curRoot = null;
            }
            return curRoot;
        }

        int index = s.charAt(depth) - 'a';
        curRoot.child[index] = delete(curRoot.child[index], s, depth + 1);
        if (isEmptyRoot(curRoot) && !curRoot.isEndOfWord) {
            curRoot = null;
        }
        return curRoot;
    }
}
