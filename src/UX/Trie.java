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

    int convertIndex(char c) {
        if (c == 'ə' ) return 256;
        return (int) c;
    }

    char convertChar(int id) {
        if (id == 256) return 'ə';
        return (char) (id);
    }

    public void insert(String s) {
        TrieNode curNode = root;
        for (int i = 0; i < s.length(); ++i) {
            int index = convertIndex(s.charAt(i));
            if (curNode.child[index] == null)
                curNode.child[index] = new TrieNode();
            curNode = curNode.child[index];
        }
        curNode.isEndOfWord = true;
    }

    public ArrayList<String> search(String s) {
        ArrayList<String> results = new ArrayList<String>();
        s = s.toLowerCase();
        for (char c : s.toCharArray())
            if (c != 'ə' && ((int) c < 0 || (int) c > 255)) {
                return results;
            }
        TrieNode curNode = root;
        for (int i = 0; i < s.length(); ++i) {
            int index = convertIndex(s.charAt(i));
            if (curNode.child[index] == null)
                return results;
            curNode = curNode.child[index];
        }
        dfsTrie(curNode, results, s);
        return results;
    }

    public void dfsTrie(TrieNode curNode, ArrayList<String> results, String prefix) {
        if (curNode.isEndOfWord) results.add(prefix);
        if (results.size() >= 100) return;
        for (int i = 0; i < 257; ++i) {
            if (curNode.child[i] != null) {
                char add = convertChar(i);
                dfsTrie(curNode.child[i], results, prefix + add);
            }
        }
    }

    public boolean isEmptyRoot(TrieNode curRoot) {
        for (int i = 0; i < 257; ++i) {
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

        int index = convertIndex(s.charAt(depth));
        curRoot.child[index] = delete(curRoot.child[index], s, depth + 1);
        if (isEmptyRoot(curRoot) && !curRoot.isEndOfWord) {
            curRoot = null;
        }
        return curRoot;
    }
}
