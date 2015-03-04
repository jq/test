package Util;

import java.util.HashMap;
import java.util.List;

public class CollectionGen {

    public static <T,V> HashMap<T, V> toMap(T[] s, V v) {
    	HashMap<T, V> set = new HashMap<T, V>(s.length*2);
    	for (T str : s) {
    		set.put(str, v);
    	}
    	return set;
    }
    public static <T> HashMap<T, Boolean> toMap(T[] s) {
        return toMap(s, false);
    }
    public static <T,V> HashMap<T, V> toMap(List<T> s, V v) {
        HashMap<T, V> set = new HashMap<T, V>(s.size()*2);
        for (T str : s) {
            set.put(str, v);
        }
        return set;
    }
    public static <T> HashMap<T,Integer> toMapCount(List<T> s) {
        HashMap<T, Integer> set = new HashMap<T, Integer>(s.size()*2);
        for (T t : s) {
            Integer i = set.get(t);
            if (i == null) {
                set.put(t, 1);
            } else {
                i += 1;
            }
        }
        return set;
    }

}
