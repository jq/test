package Util;

import java.util.ArrayList;
import java.util.List;

public class TrieNode{
   private TrieNode parent;
   private final TrieNode[] children;
   private boolean isLeaf;     //Quick way to check if any children exist
   private boolean isWord;     //Does this node represent the last character of a word
   private char character;     //The character this node represents

   public TrieNode() {
      children = new TrieNode[26];
      isLeaf = true;
      isWord = false;
   }
   public TrieNode(char character)   {
      this();
      this.character = character;
   }
   
   /**
    * Adds a word to this node. This method is called recursively and
    * adds child nodes for each successive letter in the word, therefore
    * recursive calls will be made with partial words.
    * @param word the word to add   */
   protected void addWord(String word)  {
      isLeaf = false;
      int charPos = word.charAt(0) - 'A';
      
      if (children[charPos] == null) {
          children[charPos] = new TrieNode(word.charAt(0));
          children[charPos].parent = this;
      }
      
      if (word.length() > 1) {
          children[charPos].addWord(word.substring(1));
      } else {
          children[charPos].isWord = true;
      }
   }
   
   protected TrieNode getNode(char c)  {
      return children[c - 'A'];
   }
   
   /**
    * Returns a List of String objects which are lower in the
    * hierarchy that this node.    */
   protected List<String> getWords()   {
      //Create a list to return
      List<String> list = new ArrayList<String>();
      
      //If this node represents a word, add it
      if (isWord) {
          list.add(toString());
      }
      
      if (!isLeaf) {
          //Add any words belonging to any children
          for (int i=0; i<children.length; i++)      {
             if (children[i] != null)         {
                list.addAll(children[i].getWords());
             }
          }
      }
      return list; 
   }
   public boolean isWord() {
       return isWord;
   }
    /**
    * Gets the String that this node represents.
    * For example, if this node represents the character t, whose parent
    * represents the charater a, whose parent represents the character
    * c, then the String would be "cat".   */
    @Override  public String toString() {
        if (parent == null) {
             return "";//是因为有root
        }else{
             return parent.toString() + new String(new char[] {character});
        }
    } 
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                