package bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

import Util.CollectionGen;

public class WordLadder extends Bfs <String> {
    protected boolean search(String s, String result, Queue<String> nxt, HashMap<String, Boolean> dict) {
        StringBuilder buf = new StringBuilder(s);
        for (int i = 0; i < s.length(); ++i) {
            char b = s.charAt(i);
            for (char a = 'a'; a <= 'z'; ++a) {
                if (a != b) {
                    buf.setCharAt(i, a);
                    String n = buf.toString();
                    if (n.equalsIgnoreCase(result)) {
                        return true;
                    }
                    Boolean has = dict.get(n);
                    if (has != null && !has.booleanValue()) {
                        nxt.add(n);
                        dict.put(n, true);
                    }
                    buf.setCharAt(i, b);
                }
            }
        }
        return false;
    }
    @Test
    public void testG() {
        String[] s = {"hot","dot","dog","lot","log"};
        Assert.assertEquals(0, minDepth("hit", "hit", CollectionGen.toMap(s)));
        Assert.assertEquals(4, minDepth("hit", "cog", CollectionGen.toMap(s)));
    }
}
