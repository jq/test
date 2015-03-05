package details;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class ZigZag {
    public static String run(String s, int n) {
        StringBuilder b = new StringBuilder(s.length());
        for (int i = 0; i < n; ++i) {
            for (int j = 0, index = i; index < s.length(); j++, index = (n*2-2)*j + i) {
                b.append(s.charAt(index));
                if (i == 0 || i == (n-1)) continue;
                int diagonalIndex = index + (n-1-i)*2;
                if (diagonalIndex < s.length()){
                    b.append(s.charAt(diagonalIndex));
                }
            }
        }
        return b.toString();
    }
    @Test
    public void test() {
        Assert.assertEquals("PAHNAPLSIIGYIR", run("PAYPALISHIRING", 3));
    }

}
