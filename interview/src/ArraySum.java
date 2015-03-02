import org.junit.Test;

// Given an array of integers eg [1,2,-3,1] 
// find whether there is a sub-sequence that sums to 0 and return it (eg 1,2,-3 or 2,-3,1)
// he solution by Interview Candidate (do a running sum and return
// when you see a sum already seen) works for all cases. If the list is [1, 2, 1, -3, -4], S1 = 1;
//S2 = 3 (1 + 2);
//S3 = 4 (1 + 2 + 1)
//S4 = 1 (1 + 2 + 1 -3) ... since we have already seen this sum at index 1.
// the answer is list of numbers at [old_sums_index + 1, new_sums_index] = [2, 1, -3]
//5 1 -1 2 -2 vs 5 1 -1 3 2 -2
public class ArraySum {
	@Test
	public void testG() {
		int[] data = {1,2,-3,1};
	}
	
	public boolean sumToZero(int[] a) {
		
		
		return false;
	}
}
