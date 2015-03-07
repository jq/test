package linear;


import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDupFromSort {
    public static int[] allTwice(int[] a) {
        int pos = 0;
        int count = 0;
        for (int i = 0; i<a.length; ++ i) {
            if (a[pos] != a[i] || count>1) {
                pos++;
                a[pos] = a[i];
            } else {
                count++;
            }
        }
        return Arrays.copyOf(a, pos+1);
    }
    public static int[] run(int[] a) {
        int pos = 0;
        for (int i = 0; i<a.length; ++ i) {
            if (a[pos] != a[i]) {
                pos++;
                a[pos] = a[i];
            }
        }
        return Arrays.copyOf(a, pos+1);
    }
    @Test
    public void test() {
        int[] a = {1,1,2,2,3,5,7,8,8,8,8};
        int[] b = {1,2,3,5,7,8};
        int[] b1 = {1,2,3,5,7,8,8};
        Assert.assertArrayEquals(b, run(a));
        //Collections.sort(list);
    }

}
