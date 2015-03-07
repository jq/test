package linear;


import org.junit.Assert;
import org.junit.Test;

public class RemoveDupFromSort {
    public static void run(int[] a) {
        
    }
    @Test
    public void test() {
        int[] a = {1,1,2,2,3,5,7,8,8,8,8};
        int[] b = {1,2,3,5,7,8};
        
        Assert.assertArrayEquals(a, b);
        //Collections.sort(list);
    }

}
