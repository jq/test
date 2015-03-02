import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Util {
  //http://www.ics.uci.edu/~eppstein/161/960227.html
	public static int strstr(String p, String t) {
		for (int i=0; i<t.length(); ++i) {
			for (int j = 0; (i+j) < t.length() && t.charAt(i+j) == p.charAt(j) ; ++j) {
				if (j == p.length() - 1) {
					return i;
				}
			}
		}
		return -1;
	}

	public static int[] getOverlap(String p) {
		int[] f = new int[p.length()];
		f[0] = 0;
		for (int i = 1; i < p.length(); ++i) {
			int j = f[i-1];
			if (p.charAt(i) == p.charAt(j)) {
				f[i] = j + 1;
			} else {
				f[i] = j;
				
			}
		}
		return f;
	}
	
	public static int strstrWithSkip(String p, String t) {
		int i = 0;
		while (i < t.length()) {
			int j = 0;
			for (j = 0; (i+j) < t.length() && t.charAt(i+j) == p.charAt(j) && j < p.length() ; ++j);
			if (j == p.length() - 1) {
				return i;
			} else {
				//i = i + 
			}
		}
		return -1;
	}
	
	public static void matrixRotate(int[][] a) {
    	int len = a.length;
    	for (int i = 0; i < len/2; ++i) {
    		for (int j = i; j < len - i - 1; ++i) {
    			int top = a[i][j];
    			a[i][j] = a[len - j - 1][i];
    			a[len - j - 1][i] = a[len - i -1][len - j - 1];
    			a[len - i - 1][len - j -1] = a[j][len - i -1];
    			a[j][len - i -1] = top; 
    		}
    	}
    }

	// i++ == { k=i; i=i+1; return k} ++i == {i=i+1; return i;} so it is ok to put what ever in for loop
	//Returns a^b, as the standard mathematical exponentiation function	 2^(-2) =  1/2 * 1/2
	// new java style is use the for (int i:d) was to use new container obj to remove the need of index
	// https://today.java.net/today/2007/11/06/MathPow.java
	// http://www.careercup.com/question?id=14959760
	public static double pow(double a, int b) {
	    if (b == 0) {
	        return 1;
	      } else {
	    	  double factor =  (b > 0)?a:1/a;
		      double result = factor;
		      for (int i = 0; i < b -1; ++i) {
		        result *= a;
		      }
		      return result;
	      }
	}

	public static boolean same(char a, char b) {
		return a == b || Character.toLowerCase(a) == Character.toLowerCase(b);
	}
	
	public static boolean fuzzyPalindrome (String s) {
		int len = s.length();
		
		for (int i = 0; i < len/2; ++i) {
			if (!same(s.charAt(i), s.charAt(len - i -1))) return false;
		}
		
		return true;
	}
	
	public static int stringEditDistance(String s1, String s2) {
		if (s1.length() == 0) {
			if (s2.length() == 0) {
				return 0;
			} else {
				return s2.length();
			}
		} else if (s2.length() == 0) {
			return s1.length();
		}
		int [][] m = new int[s1.length()+1][s2.length()+1];
		m[0][0] = 0;
		
		for (int i = 0; i <= s2.length(); ++i) {
			m[0][i] = i;
		}
		for (int i = 0; i <= s1.length(); ++i) {
			m[i][0] = i;
		}
		for (int i = 1; i <= s1.length(); ++i) {
			for (int j = 1; j <= s2.length(); ++j) {
				
				m[i][j] = Math.min(m[i-1][j-1] + ((s1.charAt(i-1) == s2.charAt(j-1))?0:1), 
						Math.min(m[i-1][j]+1, m[i][j-1]+1));
			}
		}
		return m[s1.length()][s2.length()];
	}
	
	
	public static boolean isOP(char c) {
		return (c == '+') || c == '-' || c == '*' || c == '/';
	}
	public static Integer compute(Integer first, char op, Integer second) {
		switch (op) {
		case '+' : return first + second;
		case '-' : return first - second;
		case '*' : return first * second;
		case '/' : return first / second;
		default : // error
			throw new RuntimeException("wrong op " + op);
		}
	}
	public static int getRpn(String rpn) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < rpn.length(); i++) {
			char c = rpn.charAt(i);
			if (isOP(c)) {
				Integer second = s.pop();
				Integer first = s.pop();
				Integer result = compute(first, c, second);
				s.push(result);
			} else {
				s.push((int) c - '0');
			}
		}
		return s.pop();
	}
	
	/*
	 * Returns true if the input string is a number and false otherwise
	 */
	// -1, 0.3, 00, 0101, .3, -.3 -0.3
	//  ab,   0..3, 
	public static boolean isNumber(char c) {
	  return c >='0' && c <= '9';
	}
	public static boolean isNumber(String toTest)
	{
	    // implementation here
	    int len = toTest.length();
	    
	    for (int i = 0; i < len; ++i) {
	      char c = toTest.charAt(i);
	      if (!isNumber(c)) {
	        if (i!=0 || c != '-') {
	               
	          return false;
	        }
	      }
	    }
	    return true;
	}

	// 1, 3, 4, 6} - {2, 3, 5} = {1, 4, 6}	// 2,3    1,2
	public static ArrayList sub(int[] a, int[] b) {
	  int i = 0;
	  int j = 0;
	  ArrayList r = new ArrayList();
	  while (i < a.length && j < b.length) {
	    if (a[i] < b[j]) {
	      r.add(a[i]);
	      ++i;
	    } else if (a[i] == b[j]) {
	      ++i;
	      ++j;
	    } else {
	      ++j;
	    }
	  
	  }
	  for (; i<a.length; ++i) {
	    r.add(a[i]);
	  }
	  return r;
	}

	/** 
	 * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
	 * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
	 * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
	 */
	public static int depthSum (List<NestedInteger> input)
	{
	    //Implementation here
	    return depthSumHelp(input, 1);
	}

	public static int depthSumHelp (List<NestedInteger> input, int depth) {

	    int sum = 0;
	    for (NestedInteger n : input) {
	      if (n.isInteger()) {
	        sum += n.getInteger() * depth;
	      } else {
	        sum += depthSumHelp(n.getList(), depth+1);
	      } 
	    }
	    return sum;
	}
	/**
	 * This is the interface that allows for creating nested lists. You should not implement it, or speculate about its implementation
	 */
	public interface NestedInteger 
	{
	    // Returns true if this NestedInteger holds a single integer, rather than a nested list
	    public boolean isInteger();
	 
	    // Returns the single integer that this NestedInteger holds, if it holds a single integer
	    // Returns null if this NestedInteger holds a nested list
	    public Integer getInteger();
	 
	    // Returns the nested list that this NestedInteger holds, if it holds a nested list
	    // Returns null if this NestedInteger holds a single integer
	    public List<NestedInteger> getList();
	}




}
