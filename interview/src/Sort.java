import java.util.Vector;


public class Sort {
	//find the dominator of an array with 1,000,000 
	// element and complete within O(n) complexity £ºUsing Moore¡¯s Voting Algorithm
	// hard to define interface, so maybe just throw exception
	public static int domiator(int[] a) {
		int count = 1;
		int d = a[0];
		for (int i = 1; i < a.length; ++i) {
			if (d != a[i]) {
				--count;
			} else {
				++count;
			}
			if (count == 0) {
				d = a[i];
				count = 1;
			}
		}
		
		count = 0;
		for (int i = 0; i < a.length; ++i) {
			if (d == a[i]) ++count;
		}
		
		if (count > (a.length/2)) return d;
		else 
		throw new RuntimeException("no dominator");
	}
	// find the element P in an array which all the elements 
	// before P less than or equal to P and the elements after P 
	// larger than to equal to P
	public static Vector<Integer> getMagic(int[] a) {
		int[] mins = new int[a.length];
		int[] maxs = new int[a.length];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		mins[a.length-1] = Integer.MAX_VALUE;
		maxs[0] = Integer.MIN_VALUE;
		for (int i = 1; i < a.length; ++i) {
			if (max < a[i-1]) {
				max = a[i-1];
			}
			maxs[i] = max;
		}
		for (int i = a.length - 2; i >= 0; --i) {
			if (min > a[i+1]) {
				min = a[i+1];
			}
			mins[i] = min;
		}

		Vector<Integer> c = new Vector<Integer>(a.length);
		for (int i = 0; i < a.length; ++i) {
			if (mins[i] > a[i] && maxs[i] < a[i]) {
				c.add(a[i]);
			}
		}
		return c;
	}
}
