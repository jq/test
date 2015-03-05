package details;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class SpiralMatrix {
    // m*n
    public static List<Integer> run(int[][] a) {
        List<Integer> r = new ArrayList<Integer>(a.length * a[0].length);
        int endx = a[0].length - 1;
        int endy = a.length - 1;
        int bx = 0;
        int by = 0;
        while(true) {
          for (int i = bx; i <= endx; ++i) {
              r.add(a[by][i]);
          }
          by++;
          if (by > endy) break;
          for (int i = by; i <= endy; ++i) {
              r.add(a[i][endx]);
          }
          endx--;
          if (bx > endx) break;
          for (int i = endx; i >=bx; --i) {
              r.add(a[endy][i]);
          }
          endy--;
          if (by > endy) break;
          for (int i = endy; i >=by; --i) {
              r.add(a[i][bx]);
          }
          bx++;
          if (bx > endx) break;
        }
        return r;
    }
    @Test
    public void test() {
        List<Integer> a1 = Arrays.asList(1,2,3,6,9,8,7,4,5);
        int[][] b1 = {{1,2,3},
                      {4,5,6},
                      {7,8, 9}};
        Assert.assertEquals(a1, run(b1));
        List<Integer> a2 = Arrays.asList(1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10);
        int[][] b2 = {{1,2,3,4},
                      {5,6,7,8},
                      {9,10,11,12},
                      {13,14,15,16}};
        Assert.assertEquals(a1, run(b1));
    }

}
