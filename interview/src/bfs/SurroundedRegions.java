package bfs;

import junit.framework.Assert;

import org.junit.Test;

public class SurroundedRegions {
    public static int[][] run(int[][] n) {
        
        return n;
    }
    @Test
    public void test() {
        int[][] a1 = {{1,1,1,1},
                      {1,1,1,1},
                      {1,1,1,1},
                      {1,0,1,1}};
        int[][] b1 = {{1,1,1,1},
                      {1,0,0,1},
                      {1,1,0,1},
                      {1,0,1,1}};
        Assert.assertEquals(a1, run(b1));
    }

}
