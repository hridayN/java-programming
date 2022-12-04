package DataStructures.TrieDS;

import java.util.Locale;

public class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    private class TrieNode {
        private TrieNode[] children;    // Collection of alphabets
        private boolean isWord;         // TODO: Add definition

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }

    }

    public void InsertWord(String word) {
        if (word != null && !word.isEmpty()) {
            word = word.toLowerCase();
            TrieNode current = root;
            for (int i =0; i < word.length(); i++) {
                char c = word.charAt(i);

                // Get children's index, at which new char will be inserted
                int indexToBeInsertedAt = IndexToBeInsertedAt(c);

                // Check if current's children at {index} is empty
                if (current.children[indexToBeInsertedAt] == null) {
                    TrieNode node = new TrieNode();
                    current.children[indexToBeInsertedAt] = node;
                    current = node;
                } else {
                    current = current.children[indexToBeInsertedAt];
                }
            }
            current.isWord = true;
        }
    }

    public int IndexToBeInsertedAt(char c) {
        return c - 'a';
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.InsertWord("Cat");
    }
}
