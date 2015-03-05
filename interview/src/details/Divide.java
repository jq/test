package details;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class Divide {
    // every time it starts with 1 divident and double up.
    // if it is same O(n) don't be too smart.
    public static int run(int divisor, int divident) {
        int result = 0;
        boolean sign = (divisor > 0 && divident < 0) || (divisor < 0 && divident > 0);
        long a = Math.abs(divisor);
        long b = Math.abs(divident);
        while (b < a) {           // 
            int base = 1;
            long x = b;// 10
            while (x <= a) {//
                result += base;
                a -= x; // 90,1, 2, 20, 70, 3, 40, 4, 7,30,  
                x += x;
                base += base;
            }
        }
        if (sign) result = - result;
        return result;
    }
    @Test
    public void test() {
        Assert.assertEquals(10, run(100,10));
        Assert.assertEquals(10, run(104,10));
        Assert.assertEquals(11, run(114,10));
    }

}
