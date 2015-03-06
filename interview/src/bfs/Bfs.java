package bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
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
    
    protected abstract boolean genPath(T t, T result, Queue<T> nxt, HashMap<T, Boolean> dict, HashMap<T, Vector<T>> path);
    public ArrayList<ArrayList<T>> bfsPath(T start, T end, HashMap<T, Boolean> dict) {
        if (start.equals(end)) return null;
        Queue<T> cur = new LinkedList<T>();
        Queue<T> nxt = new LinkedList<T>();
        cur.add(start);
        HashMap<T, Vector<T>> path = new HashMap<T, Vector<T>>();
        path.put(end, new Vector<T>());
        boolean found = false;
        while (!cur.isEmpty() && !found) {
            for (T s : cur) {
                dict.put(s, true);
            }
            while (!cur.isEmpty()) {
                T s = cur.poll();
                boolean r = genPath(s, end, nxt, dict, path);
                if (r) found = true;
            }
            Queue<T> tmp = cur;
            cur = nxt;
            nxt = tmp;
        }
        if (!found) return null;
        ArrayList<ArrayList<T>> result = new ArrayList<ArrayList<T>>();
        getPath(start, end, result, path, new Vector<T>());
        return result;
    }

    public void getPath(T start, T end,ArrayList<ArrayList<T>> result,
            HashMap<T, Vector<T>> tree, Vector<T> path) {
        path.add(end);
        if (end.equals(start)) {
            ArrayList<T> p = new ArrayList<T>(path);
            result.add(p);
            return;
        }

        Vector<T> v = tree.get(end);
        if (v != null) {
            for (T s : v) {
                getPath(start, s, result, tree, path);
            }
        }
        path.remove(path.size() - 1);
    }

}
