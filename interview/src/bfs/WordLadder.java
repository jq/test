package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import Util.CollectionGen;

public class WordLadder extends Bfs <String> {
    @Override
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
    @Override
    protected boolean genPath(String s, String result, Queue<String> nxt,
            HashMap<String, Boolean> dict, HashMap<String, Vector<String>> path) {
        boolean found = false;
        StringBuilder buf = new StringBuilder(s);
        for (int i = 0; i < s.length(); ++i) {
            char b = s.charAt(i);
            for (char a = 'a'; a <= 'z'; ++a) {
                if (a != b) {
                    buf.setCharAt(i, a);
                    String n = buf.toString();
                    buf.setCharAt(i, b);
                    if (n.equalsIgnoreCase(result)) {
                        found = true;
                        Vector<String> v = path.get(result);
                        v.add(s);
                        break;
                    }
                    Boolean has = dict.get(n);
                    if (has != null) {
                        if (!has.booleanValue()) {
                            // add to path
                            Vector<String> v = path.get(n);
                            if (v == null) {
                                v = new Vector<String>();
                                path.put(n, v);
                            }
                            v.add(s);
                            nxt.add(n);
//                          dict.put(n, true);
                        }
                    }
                }
            }
        }
        return found;
    }
    
    // return 从start 到end要有几次变化， 这个也是1个解
    public static int bfs(String start, String end, HashMap<String, Boolean> dict) {
        if (start.equalsIgnoreCase(end)) return 0;
        Queue<String> cur = new LinkedList<String>();
        Queue<String> nxt = new LinkedList<String>();
        cur.add(start);
        int level = 0;
        boolean found = false;
        while (!cur.isEmpty() && !found) {
            ++level;
            while (!cur.isEmpty() && !found) {
                String s = cur.poll();
                StringBuilder buf = new StringBuilder(s);
                for (int i = 0; i < s.length() && !found; ++i) {
                    char b = s.charAt(i);
                    for (char a = 'a'; a <= 'z'; ++a) {
                        if (a != b) {
                            buf.setCharAt(i, a);
                            String n = buf.toString();
                            buf.setCharAt(i, b);
                            if (n.equalsIgnoreCase(end)) {
                                found = true;
                                break;
                            }
                            Boolean has = dict.get(n);
                            if (has != null && !has.booleanValue()) {
                                nxt.add(n);
                                dict.put(n, true);
                            }
                        }
                    }
                }
            }
            Queue<String> tmp = cur;
            cur = nxt;
            nxt = tmp;
        }
        if (found) return level;
        return 0;
    }
    @Test
    public void testG() {
        String[] s = {"hot","dot","dog","lot","log"};
        Assert.assertEquals(0, minDepth("hit", "hit", CollectionGen.toMap(s)));
        Assert.assertEquals(4, minDepth("hit", "cog", CollectionGen.toMap(s)));
        ArrayList<ArrayList<String>> r = bfsPath("hit", "cog", CollectionGen.toMap(s));
        Assert.assertEquals(2, r.size());
        String[] s1 = {"hot","dot","dog","bot","bog"};
        r = bfsPath("hit", "cog", CollectionGen.toMap(s1));
        Assert.assertEquals(2, r.size());

        //String[] s = {"hot","dot","dog","lot","log"};
        Assert.assertEquals(0, bfs("hit", "hit", CollectionGen.toMap(s)));
        Assert.assertEquals(4, bfs("hit", "cog", CollectionGen.toMap(s)));

    }
}
