package details;

import junit.framework.Assert;

import org.junit.Test;

public class PalindromeNumber {

    public static boolean isPalindromeNumber(int v) {
        if (v < 0) return false;
        int r = 1;
        int k = v;
        while (k >= 10) {
            k /= 10;
            r *= 10;
        }
        while (v >= 10) {
            int a = v % 10;
            int b = v / r;
            if (a != b) return false;
            v -= r;
            v /= 10;
            r /= 100;
        }
        return true;
    }
    @Test
    public void test() {
        Assert.assertEquals(true, isPalindromeNumber(121));
        Assert.assertEquals(true, isPalindromeNumber(1));
        Assert.assertEquals(true, isPalindromeNumber(1221));
        Assert.assertEquals(true, isPalindromeNumber(1000000001));
        Assert.assertEquals(false, isPalindromeNumber(10));
        Assert.assertEquals(false, isPalindromeNumber(1000));
        Assert.assertEquals(false, isPalindromeNumber(-100));
    }

}
