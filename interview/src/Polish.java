import java.util.Stack;

import junit.framework.Assert;

import org.junit.Test;


public class Polish {
	
	@Test
	public void testP() {
		Assert.assertEquals(10, "52*");
	}
	
	public int cal(final String polish) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = polish.length();
		for (int i = 0; i < len; ++i) {
			char c = polish.charAt(i);
			switch (c) {
				case '+':
					if (stack.size() < 2) {
						throw new RuntimeException("stack size " + stack.size());
					}
					int a = stack.pop();
					int b = stack.pop();
					stack.push(a+b);
					break;
				case '-':
					break;
				case '*':
					break;
				case '/':
					break;
				default:
					if (c > '9' || c < '0') {
						// error
						throw new RuntimeException("not a number " + c);
					} else {
						stack.push(c-'0');
					}
			}
		}
		
		return 0;
	}
}
