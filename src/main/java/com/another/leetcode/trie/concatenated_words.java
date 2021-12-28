package com.another.leetcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class concatenated_words {
    Trie trie = new Trie();

    class Trie {
        char c;
        boolean isEnd;
        Trie[] child = new Trie[26];


    }

    public void insert(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new Trie();
            }
            node = node.child[index];
        }
        node.isEnd = true;


    }

    public boolean dfs(String s, int pos) {
        Trie node = trie;
        if (s.length() == pos)
            return true;
        for (int j = pos; j < s.length(); j++) {
            int x = s.charAt(j) - 'a';
            node = node.child[x];
            if (node == null) {
                return false;
            }
            if (node.isEnd) {
                if (dfs(s, j + 1)) {
                    return true;
                }
            }


        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }
            if (dfs(word, 0)) {
                ans.add(word);
            } else {
                insert(word);
            }
        }
        return ans;

    }

}
