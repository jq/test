package details;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class PascalTriangle {

    public static List<List<Integer>> gen(int n) {
        List<List<Integer>> r = new ArrayList<List<Integer>>(n);
        List<Integer> a1 = Arrays.asList(1);
        r.add(a1);
        if (n < 2) return r;
        List<Integer> a2 = Arrays.asList(1,1);
        r.add(a2);
        while (n > 2) {
            List<Integer> l = r.get(r.size()-1);
            List<Integer> a = new ArrayList<Integer>(l.size() + 1);
            a.add(1);
            for (int i = 0; i < l.size() - 1; ++i) {
                int sum = l.get(i) + l.get(i+1);
                a.add(sum);
            }
            a.add(1);
            r.add(a);
            n--;
        }
        return r;
    }
    @Test
    public void test() {
        List<Integer> a1 = Arrays.asList(1);
        List<Integer> a2 = Arrays.asList(1,1);
        List<Integer> a3 = Arrays.asList(1,2,1);
        List<Integer> a4 = Arrays.asList(1,3,3,1);
        List<Integer> a5 = Arrays.asList(1,4,6,4,1);
        List<List<Integer>> a = Arrays.asList(a1,a2,a3,a4,a5);
        Assert.assertEquals(a, gen(5));
    }

}
