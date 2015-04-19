package details;

import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Test;
/********************************************************************************** 
* 
* Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*               
**********************************************************************************/

public class MaxPointsOnLine {
    public static class Point {
        float x;
        float y;
    }
    public int run(Point[] p) {
        if (p.length < 3) return p.length;
        int r = 0;
        HashMap<Double, Integer> slope_count = new HashMap<Double, Integer>();
        for (int i = 0; i < p.length; ++i) {
            int samePointNum = 0;
            int point_max = 1;
            for (int j = i + 1; j < p.length; j++) {
                double s;
                float diffX = p[i].x - p[j].x;
                float diffY = p[i].y - p[j].y;
                // 两种特殊情况，一种是相同点，一种是无穷大
                if (diffX == 0) {
                    if (diffY == 0) {
                        ++samePointNum;
                        continue;
                    }
                    s = Double.MAX_VALUE;
                } else {
                    s = diffY/diffX;
                }
                int count = 0;
                Integer x = slope_count.get(s);
                if (x != null) {
                    count = x + 1;
                } else {
                    count = 2;                    
                }
                slope_count.put(s, count);
                point_max = Math.max(count, point_max);
            }
            r = Math.max(r, point_max + samePointNum);
            slope_count.clear();
        }
        return r;       
    }
    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
