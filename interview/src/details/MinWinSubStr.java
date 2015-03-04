package details;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MinWinSubStr {
	public static String get(String m, String s) {
	    if (m.length() < s.length()) return "";
		int[] expectedCount = new int[256];
		int t = s.length();
		for (int i = 0; i < t; i++) {
			char a = s.charAt(i);
			expectedCount[a]++;
		}
		int minStart=0, minEndIdx=Integer.MAX_VALUE;

		int start = 0;
        int[] count = new int[256];
        for (int end = 0; end < m.length(); end++) {
            char a = m.charAt(end);
            if (expectedCount[a] > 0) {
                count[a]++;
                if (count[a] <= expectedCount[a] && t > 0) {
                    t--;
                }
                if (t == 0) {
                    // move x
                    char n;
                    while(true) {
                        n = m.charAt(start);
                        if (count[n] > expectedCount[n]) {
                            count[n]--;
                            start++;
                        } else if (count[n] == 0) {
                            start++;
                        } else {
                            break;
                        }
                    }

                    // find solution
                    int endIdx = end + 1;
                    int len = endIdx - start;
                    System.out.println(end + " " + start);
                    if (len == s.length()) {
                        return m.substring(start, endIdx);
                    } else if (len < (minEndIdx-minStart)) {
                        minEndIdx = endIdx;
                        minStart = start;
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
