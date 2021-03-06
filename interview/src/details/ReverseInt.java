package details;

import org.junit.Assert;
import org.junit.Test;

public class ReverseInt {

    public static int reverseInt(int v) {
        if (v < 0) return -1;
        int r = 0;
        while (v > 0) {
            int a = v % 10;
            v = v / 10;
            r = r * 10 + a;
            if (r < 0) return -1;
        }
        return r;
    }
    @Test
    public void test() {
        Assert.assertEquals(0, reverseInt(0));
        Assert.assertEquals(1, reverseInt(1));
        Assert.assertEquals(12, reverseInt(21));
        Assert.assertEquals(123, reverseInt(321));
        Assert.assertEquals(-1, reverseInt(-1));
        Assert.assertEquals(321, reverseInt(12300));
        Assert.assertEquals(-1, reverseInt(1000000003));
    }

}
