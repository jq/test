import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;


public class NumToTxt {

	@Test
	public void testG() {
		for (int i = 0; i < 1000; ++i) {
//			Assert.assertEquals(i, toTxt(i));
		}
		Assert.assertEquals("ten", toTxt(10));
	}
	static final String[] STR = {"", " thousand", " million", " billion"};
	static final String[] single = {"one", "two", "3", "", "", "", "", "", "", "", ""};
	static final String[] TenAbove = {"11", "12", "3", "", "", "", "", "", "", "", ""};
	static final String[] HundredBelow = {"20", "30", "Fourti", "Fifty", "sixty", "seventy", "eighty", "nighty"};
	public static String toTxt(int n) {
		StringBuilder sb = new StringBuilder();
		toTxt(10, 0, sb);
		return sb.toString();
	}
	public static void toTxt(int n, int i, StringBuilder sb) {
		if (n > 0) {
			int r = n % 1000;
			n = n / 1000;
			toTxt(n, ++i, sb);
			toTxtUnderThousand(r, sb);
			sb.append(STR[i]);
		}
	}
	
	public static void toTxtUnderThousand(int n, StringBuilder sb) {
		if (n >= 100) {
			int r = n / 100;
			n = n % 100;
			sb.append(single[r-1]);
			sb.append(" hundred ");
		}
		if (n >= 20) {
			int r = n / 10;
			n = n % 10;
			sb.append(HundredBelow[r-2]);
		} 
		
		if (n >=10) {
			sb.append(TenAbove[n-1]);
		} else {
			sb.append(single[n-1]);
		}
	}
}
