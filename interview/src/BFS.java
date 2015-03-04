import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import Util.CollectionGen;


public class BFS {

	@Test
	public void testG() {
		String[] s = {"hot","dot","dog","lot","log"};
		Assert.assertEquals(0, bfs("hit", "hit", CollectionGen.toMap(s)));
		Assert.assertEquals(4, bfs("hit", "cog", CollectionGen.toMap(s)));
		Vector<Vector<String>> r = bfsPath("hit", "cog", CollectionGen.toMap(s));
		Assert.assertEquals(2, r.size());
		String[] s1 = {"hot","dot","dog","bot","bog"};
		r = bfsPath("hit", "cog", CollectionGen.toMap(s1));
		Assert.assertEquals(2, r.size());
	}
	public static HashSet<String> arrayToSet(String[] s) {
		HashSet<String> set = new HashSet<String>(s.length*2);
		for (String str : s) {
			set.add(str);
		}
		return set;
	}
	public static Vector<Vector<String>> bfsPath(String start, String end, HashMap<String, Boolean> dict) {
		if (start.equalsIgnoreCase(end)) return null;
		Queue<String> cur = new LinkedList<String>();
		Queue<String> nxt = new LinkedList<String>();
		cur.add(start);
		HashMap<String, Vector<String>> path = new HashMap<String, Vector<String>>();
		path.put(end, new Vector<String>());
		boolean found = false;
		while (!cur.isEmpty() && !found) {
			for (String s : cur) {
				dict.put(s, true);
			}
			while (!cur.isEmpty()) {
				String s = cur.poll();
				StringBuilder buf = new StringBuilder(s);
				for (int i = 0; i < s.length(); ++i) {
					char b = s.charAt(i);
					for (char a = 'a'; a <= 'z'; ++a) {
						if (a != b) {
							buf.setCharAt(i, a);
							String n = buf.toString();
							buf.setCharAt(i, b);
							if (n.equalsIgnoreCase(end)) {
								found = true;
								Vector<String> v = path.get(end);
								v.add(s);
								break;
							}
							Boolean has = dict.get(n);
							if (has != null) {
								if (!has.booleanValue()) {
									// add to path
									Vector<String> v = path.get(n);
									if (v == null) {
										v = new Vector<String>();
										path.put(n, v);
									}
									v.add(s);
									nxt.add(n);
//									dict.put(n, true);
								}
							}
						}
					}
				}
			}
			Queue<String> tmp = cur;
			cur = nxt;
			nxt = tmp;
		}
		if (!found) return null;
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		getPath(start, end, result, path, new Vector<String>());
		return result;
	}

	public static void getPath(String start, String end, Vector<Vector<String>> result,
			HashMap<String, Vector<String>> tree, Vector<String> path) {
		path.add(end);
		if (end.equalsIgnoreCase(start)) {
			Vector<String> p = new Vector<String>(path);
			result.add(p);
			return;
		}

		Vector<String> v = tree.get(end);
		if (v != null) {
			for (String s : v) {
				getPath(start, s, result, tree, path);
			}
		}
		path.remove(path.size() - 1);
	}

	public static int bfs(String start, String end, HashMap<String, Boolean> dict) {
		if (start.equalsIgnoreCase(end)) return 0;
		Queue<String> cur = new LinkedList<String>();
		Queue<String> nxt = new LinkedList<String>();
		cur.add(start);
		int level = 0;
		boolean found = false;
		while (!cur.isEmpty() && !found) {
			++level;
			while (!cur.isEmpty() && !found) {
				String s = cur.poll();
				StringBuilder buf = new StringBuilder(s);
				for (int i = 0; i < s.length() && !found; ++i) {
					char b = s.charAt(i);
					for (char a = 'a'; a <= 'z'; ++a) {
						if (a != b) {
							buf.setCharAt(i, a);
							String n = buf.toString();
							buf.setCharAt(i, b);
							if (n.equalsIgnoreCase(end)) {
								found = true;
								break;
							}
							Boolean has = dict.get(n);
							if (has != null && !has.booleanValue()) {
								nxt.add(n);
								dict.put(n, true);
							}
						}
					}
				}
			}
			Queue<String> tmp = cur;
			cur = nxt;
			nxt = tmp;
		}
		if (found) return level;
		return 0;
	}
}
