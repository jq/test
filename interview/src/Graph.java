import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;



public class Graph {

	boolean visited = false;
	int[] n;
	
	public Graph(int[] n_) {
		n = n_;
	}
	public static void printSet(List<Integer> s) {
		for (Integer i : s) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static Graph[] buildG(int[][] d) {
		Graph[] g = new Graph[d.length];
		int count = 0;
		for (int[] ga : d) {
			Graph i = new Graph(ga);
			g[count++] = i;
		}
		return g;
	}
	
	public static int path(Graph[] g, int a, int b) {
		assert(a >=0 && b>=0 && a < g.length && b < g.length);
		int count = 0;
		Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> alist = new ArrayList<Integer>();
		alist.add(a);
		q.add(alist); //Collections.sort(list)
		while (!q.isEmpty()) {
			ArrayList<Integer> path = q.poll();
			int last = path.get(path.size()-1);
			if (last == b) {
				printSet(path);
				++count;
			} else {
				for (int i : g[last].n) {
					if (!path.contains(i)) {
						ArrayList<Integer> newPath = ((ArrayList<Integer>)path.clone());
						newPath.add(i);
						q.add(newPath);
					}
				}
			} 
		}
		
		return count;
	}
}
