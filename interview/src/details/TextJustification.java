package details;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
// Each word is guaranteed not to exceed L in length
// A line other than the last line might contain only one word. What should you do in this case?
public class TextJustification {
    public static String combine(List<String> s, int spaceSize) {
        StringBuilder b = new StringBuilder();
        int spaceNum = (s.size()-1);      
        int space;
        int extraSpace;
        if (spaceNum == 0){
            space = spaceSize;
            extraSpace = 0;
        } else {
            space = spaceSize / spaceNum;
            extraSpace = spaceSize % spaceNum;            
        }
        for (int k = 0; k < s.size(); ++k) {
            String a = s.get(k);
            b.append(a);
            if (k != (s.size()-1) || k ==0) {
                int append;
                if (extraSpace > 0) {
                    append = space + 1;
                    extraSpace--;
                } else {
                    append = space;
                }
                for (int i = 0; i<append; i++){
                    b.append(' ');
                }
            }
        }
        return b.toString();
    }
    public static List<String> run(List<String> s, int n) {
        List<String> r = new ArrayList<String>(s.size());
        ArrayList<String> line = new ArrayList<String>();
        int c = n;
        for (String a : s) {
            if (a.length() <= c) {
                if (!line.isEmpty()) {
                    c--;
                }
                c-=a.length();
                line.add(a);
                if (c == 0) {
                    r.add(combine(line,line.size()-1));
                    line.clear();
                    c = n;
                }
            } else {
                r.add(combine(line,line.size()-1 + c));
                line.clear();
                c = n - a.length();
                line.add(a);
            }
        }
        if (!line.isEmpty()) {
            r.add(combine(line,line.size()-1 + c));
        }
        return r;
    }
    @Test
    public void test() {
        List<String> k1 = Arrays.asList("This", "is", "an");
        List<String> k2 = Arrays.asList("example", "of", "text");
        List<String> k3 = Arrays.asList("justification.");
        List<String> a1 = Arrays.asList("This", "is", "an", "example", "of", "text", "justification.");
        List<String> b1 = Arrays.asList("This    is   an",
                                        "example of text",
                                        "justification. ");
        Assert.assertEquals(b1.get(0), combine(k1, 7));
        Assert.assertEquals(b1.get(1), combine(k2, 2));
        Assert.assertEquals(b1.get(2), combine(k3, 1));
        List<String> r1 = run(a1, 15);
        Assert.assertEquals(b1, r1);
    }

}
