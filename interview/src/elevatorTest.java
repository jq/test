import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class elevatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testG() {
		BinNode.printBinTreeByLevel(BinNode.getTree(7));
		
		Assert.assertEquals(1, Util.strstr("12", "0123123"));
		
		int[][] d = {{1,4,2},{4}, {3}, {4,5}, {5}, {1}};
		Graph[] g = Graph.buildG(d);
		
		Assert.assertEquals(4, Graph.path(g, 0, 4));
		
		int[][] d1 = {{1,4,2},{0,4}, {0,3}, {2,4,5}, {0,1,3,5}, {4,3}};
		Graph[] g1 = Graph.buildG(d1);
		
		Assert.assertEquals(4, Graph.path(g1, 0, 4));
		
	}
	
	@Test
	public void testQ() {
		PQueue<Integer> q = new PQueue<Integer> (10);
		int[] d = {2,1,7,3,4,9,8,7,6,0,5}; //[0, 1, 7, 3, 2, 9, 8, 7, 6, 4, 5]
		//int[] r = {0,};
		for (int i : d) {
			q.add(i);
		}
		Integer[] a = new Integer[q.d.size()];
		q.d.toArray(a);
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		
		Assert.assertEquals(d.length, q.d.size());
		int last = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int now = q.poll();
			Assert.assertTrue(last <= now);
			last = now;
		}
		//Assert.assertEquals(2, Sort.domiator(d));
		
	}
	
	@Test
	public void test() {
		
		int[] d = {2,2,2,3,3,3,2,1,4,2,2};
		Assert.assertEquals(2, Sort.domiator(d));
		
		int[] i = {2,3,4,5,6,7};
		Vector<Integer> v = Sort.getMagic(i);
		Assert.assertEquals(i.length,v.size());
		
		i = new int[]{2,4,5,6,7,3};
		//Arrays.sort(i);
		//Collections.sort(list);
		v = Sort.getMagic(i);
		
		Assert.assertEquals(1,v.size());
		
		Assert.assertTrue(Reg.isMatch("", ""));
		Assert.assertTrue(!Reg.isMatch("", "ab"));
		Assert.assertTrue(!Reg.isMatch("ab", ""));
		Assert.assertTrue(Reg.isMatch("abc", "abc")); 
		Assert.assertTrue(Reg.isMatch("a", "a*"));
		Assert.assertTrue(Reg.isMatch("aaa", "a*"));
		Assert.assertTrue(Reg.isMatch("aa", ".a"));
		Assert.assertTrue(Reg.isMatch("abcdefg", ".*"));
		Assert.assertTrue(!Reg.isMatch("abcde", "abc"));
		Assert.assertTrue(Reg.isMatch("abcde", "ab.de"));
		Assert.assertTrue(!Reg.isMatch("abcedfgeh", "a.*e"));
		Assert.assertTrue(Reg.isMatch("abcedfgeh", "a.*h"));
		Assert.assertTrue(Reg.isMatch("abcdefghigkemnop", "a.*ig.*p"));
		Assert.assertTrue(!Reg.isMatch("abcdefghigkemnop", "a.*ii.*p"));

		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		Util.matrixRotate(a);
		int[] a0 = {7,4,1};
		int[] a1 = {8,5,2};
		int[] a2 = {9,6,3};
		Assert.assertArrayEquals(a[0], a0);
		Assert.assertArrayEquals(a[1], a1);
		Assert.assertArrayEquals(a[2], a2);
		
		Assert.assertFalse(Util.fuzzyPalindrome("54*"));
		Assert.assertFalse(!Util.fuzzyPalindrome("545"));
		Assert.assertFalse(!Util.fuzzyPalindrome("A4a"));

		Assert.assertEquals("Should be 20", 20, Util.getRpn("54*"));
		Assert.assertEquals("Should be 3", 3, Util.getRpn("54-3*"));
		Assert.assertEquals("0 ", 0,Util.stringEditDistance("", ""));
		Assert.assertEquals("2 ", 2,Util.stringEditDistance("123", "1"));
		Assert.assertEquals("0 ", 0,Util.stringEditDistance("123", "123"));
		Assert.assertEquals("2 ", 2,Util.stringEditDistance("1", "123"));
		Assert.assertEquals("5 ", 5,Util.stringEditDistance("", "12345"));

	}

}
