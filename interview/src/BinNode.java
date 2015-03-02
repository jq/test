import java.util.LinkedList;
import java.util.Queue;


public class BinNode<T> {
	public T data;
	public BinNode<T> left;
	public BinNode<T> right;
	public BinNode(T t) {
		data = t;
	}
	public String toString() {
		return data.toString();
	}
	public static BinNode<Integer> getTree(int num) {
		BinNode<Integer> root = new BinNode<Integer>(num);
		Queue<BinNode<Integer>> q = new LinkedList<BinNode<Integer>>();
		q.add(root);
		while (num > 0) {
			BinNode<Integer> top = q.peek();
			if (top.left == null) {
				num--;
				top.left = new BinNode<Integer>(num);
				q.add(top.left);
				continue;
			}
			if (top.right == null) {
				num--;
				top.right = new BinNode<Integer>(num);
				q.remove();
				q.add(top.right);
			}
		}
		
		return root;
	}

	public static void printBinTreeByLevel(BinNode<Integer> root) {
		Queue<BinNode<Integer>> q = new LinkedList<BinNode<Integer>>();
		q.add(root);
		while (!q.isEmpty()) {
			BinNode<Integer> top = q.poll();
			System.out.print(top.toString());
			if (top.left != null) {
				q.add(top.left);
			}
			if (top.right != null) q.add(top.right);
		}
		System.out.println();
	}

	
}
