package bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Bfs<T> {
    protected abstract boolean search(T t, T result, Queue<T> nxt, HashMap<T, Boolean> dict);
        
    public int minDepth(T start, T end, HashMap<T, Boolean> dict) {
        if (start.equals(end)) return 0;
        Queue<T> cur = new LinkedList<T>();
        Queue<T> nxt = new LinkedList<T>();
        cur.add(start);
        int level = 0;
        while (!cur.isEmpty()) {
            ++level;
            while (!cur.isEmpty()) {
                T s = cur.poll();
                if (search(s, end, nxt, dict)) return level;
            }
            Queue<T> tmp = cur;
            cur = nxt;
            nxt = tmp;
        }
        return 0;
    }

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

}
