package Util;

import java.util.List;

public class Trie {
   private final TrieNode root;
   public Trie() {
      root = new TrieNode();
   }
   
   public void addWord(String word)   {
      root.addWord(word);
   }
   private TrieNode getNode(String prefix) {
       TrieNode lastNode = root;
       for (int i=0; i<prefix.length(); i++)      {
           lastNode = lastNode.getNode(prefix.charAt(i));
           if (lastNode == null) return null;      
       }
       return lastNode;
   }
   public List<String> getWords(String prefix)  {
       TrieNode lastNode = getNode(prefix);
       if (lastNode != null) {
           return lastNode.getWords();
       } else {
           return null;
       }
   }

   public boolean search(String key) {
       TrieNode lastNode = getNode(key);
       if (lastNode != null) {
           return lastNode.isWord();
       } else {
           return false;
       }
   }
   public boolean startWith(String prefix) {
       TrieNode lastNode = getNode(prefix);
       return lastNode != null;
   }
}
