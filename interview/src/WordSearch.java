import static java.lang.System.out;
//curl 'https://pad.squareup.com/ep/pad/export/2096052/latest?format=txt' > WordSearch.java && javac WordSearch.java && java -cp . WordSearch


/* 

Puzzle
-------

S I M A R C C E E T D N L T A
P A E A K O C U O N A E P E R
N U G A C A G M O P E C A N P
G U M O T N I M R E P P E P B
S I N P I A L C T S L U T O I
R U N R K A U U C H E N A A S
T S E G G I N G E O L O L T E
H M N N E A N O D R A A O M S
B U T T E R S C O T C H C E S
K U G P T N B A B B T S O A A
U S S S E U N R N R S M H L L
C I N N A M O N E E A C C A O
O M S N O O R A C A M N A S M
R A N I S I A R E D D U A R R


Word list
---------

ALMOND
BRAN
BUTTERSCOTCH
CHOCOLATE
CINNAMON
COCONUT
GINGERBREAD
MACAROONS
MERINGUE
MOLASSES
OATMEAL
PEANUT
PECAN
PEPPERMINT
PUMPKIN
RAISIN
SHORTBREAD
SUGAR

*/
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import Util.Trie;

public class WordSearch {

	/**
	 * given matrix of strings, check if one of the words in it?
	 * if all of them in it?
	 * check for number of match 
	 * path of match
	 */
	@Test
	public void testG() {
		char[][] data = {
				{'S','I','M','A','R','C','C','E','E','T','D','N','L','T','A'},
				{'P','A','E','A','K','O','C','U','O','N','A','E','P','E','R'},
				{'N','U','G','A','C','A','G','M','O','P','E','C','A','N','P'},
				{'G','U','M','O','T','N','I','M','R','E','P','P','E','P','B'},
				{'S','I','N','P','I','A','L','C','T','S','L','U','T','O','I'},
				{'R','U','N','R','K','A','U','U','C','H','E','N','A','A','S'},
				{'T','S','E','G','G','I','N','G','E','O','L','O','L','T','E'},
				{'H','M','N','N','E','A','N','O','D','R','A','A','O','M','S'},
				{'B','U','T','T','E','R','S','C','O','T','C','H','C','E','S'},
				{'K','U','G','P','T','N','B','A','B','B','T','S','O','A','A'},
				{'U','S','S','S','E','U','N','R','N','R','S','M','H','L','L'},
				{'C','I','N','N','A','M','O','N','E','E','A','C','C','A','O'},
				{'O','M','S','N','O','O','R','A','C','A','M','N','A','S','M'},
				{'R','A','N','I','S','I','A','R','E','D','D','U','A','R','R'}};
		
		String[] words = {"ALMOND","BRAN","BUTTERSCOTCH","CHOCOLATE","CINNAMON","COCONUT","GINGERBREAD",
				"MACAROONS","MERINGUE","MOLASSES","OATMEAL","PEANUT","PECAN","PEPPERMINT","PUMPKIN","RAISIN","SHORTBREAD","SUGAR"};	
		Trie trie = new Trie();
		for (String s : words) {
			trie.addWord(s);
		}
		String word = GetOneWord(trie, data);
		Assert.assertEquals("PECAN", word);
	}

	public static String GetOneWord(Trie trie, char[][] data) {
		boolean[][] visited = new boolean[data.length][data[0].length];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j< data[i].length; ++j) {
				String word = GetOneWord(trie, data, i, j, "",visited);
				if (word != null) return word;
			}
		}
		return null;
	}
	public static String GetOneWord(Trie trie, char[][] data, int i, int j, String prefix,boolean[][] visited) {
		if (i < 0 || j < 0 || i >= data.length || j >= data[0].length) return null;
		if (visited[i][j]) return null;
		String newPrefix = prefix + data[i][j];
		@SuppressWarnings("rawtypes")
		List list = trie.getWords(newPrefix);
		if (list == null) return null;
		if (list.size() == 1) {
			String s = (String)list.get(0); 
			if (s.compareTo(newPrefix) == 0) {
				return s;
			} else {
				// could do match with real one left string with current index
			}
		}
		visited[i][j] = true;
		String s1 = GetOneWord(trie, data, i+1, j, newPrefix,visited);
		if (s1 != null) return s1;
		s1 = GetOneWord(trie, data, i, j+1, newPrefix,visited);
		if (s1 != null) return s1;
		s1 = GetOneWord(trie, data, i-1, j, newPrefix,visited);
		if (s1 != null) return s1;
		s1 = GetOneWord(trie, data, i, j-1, newPrefix,visited);
		visited[i][j] = false;
		return s1;
	}
}
