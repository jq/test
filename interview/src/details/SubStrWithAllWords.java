package details;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class SubStrWithAllWords {
    public static List<Integer> getStartIndices(final String s, List<String> d) {
        HashMap<String, Integer> base = Util.CollectionGen.toMapCount(d);
        int size = d.get(0).length();
        List<Integer> r = new ArrayList<Integer>();
        for (int i = 0; i <= s.length() - size * d.size(); ++i) {
            int len = d.size();
            HashMap<String, Integer> h = new HashMap<String, Integer>(base);
            while (len > 0) {
                int start = i + (d.size() - len) * size;
                int end = start + size;
                String str = s.substring(start , end);
                Integer count = h.get(str);
                if (count == null || count == 0) {
                    break;
                } else {
                    count--;
                    len--;
                }    
            }
            if (len == 0) {
                r.add(i);
            }
        }
        return r;
    }
    @Test
    public void test() {
        List<Integer> a = Arrays.asList(0,9);
        List<String> b = Arrays.asList("foo","bar");
        Assert.assertEquals(a,getStartIndices("barfoothefoobarman", b));
        // allow dup or not.
    }

}
