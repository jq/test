package details;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MinWinSubStr {
	public static String get(String m, String s) {
	    if (m.length() < s.length()) return "";
		int[] e = new int[256];
		int t = s.length();
		for (int i = 0; i < t; i++) {
			char a = s.charAt(i);
			e[a]++;
		}
		int minStart=0, minEndIdx=Integer.MAX_VALUE;

		int x = 0;
        int[] ap = new int[256];
        for (int end = 0; end < m.length(); end++) {
            char a = m.charAt(end);
            if (e[a] > 0) {
                ap[a]++;
                if (ap[a] <= e[a] && t > 0) {
                    t--;
                }
                if (t == 0) {
                    // move x
                    char n;
                    while(true) {
                        n = m.charAt(x);
                        if (ap[n] > e[n]) {
                            ap[n]--;
                            x++;
                        } else if (ap[n] == 0) {
                            x++;
                        } else {
                            break;
                        }
                    }

                    // find solution
                    int endIdx = end + 1;
                    int len = endIdx - x;
                    System.out.println(end + " " + x);
                    if (len == s.length()) {
                        return m.substring(x, endIdx);
                    } else if (len < (minEndIdx-minStart)) {
                        minEndIdx = endIdx;
                        minStart = x;
                    }
                } else {
                    // no solution                    
                }
            }
        }
        
        if ((minEndIdx-minStart) <= m.length()) {
            return m.substring(minStart, minEndIdx);
        } else {
            return "";
        }
		
	}
	@Test
	public void test() {
        Assert.assertEquals("BANC", get("ADOBECODEBANC","ABC"));
        Assert.assertEquals("ANC", get("ADOBECODEBANC","ANC"));
        Assert.assertEquals("ADOBEC", get("ADOBECODEBANC","ADC"));
        Assert.assertEquals("B", get("ADOBECODEBANC","B"));
        Assert.assertEquals("BE", get("ADOBECODEBANC","EB"));
	}

}
