package details;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import junit.framework.Assert;

import org.junit.Test;

public class SubStrWithAllWords {
    public static List<Integer> getStartIndices(String s, List<String> d) {
        
    }
    @Test
    public void test() {
        List<Integer> a = Arrays.asList(0,9);
        List<String> b = Arrays.asList("foo","bar");
        Assert.assertEquals(a,getStartIndices("barfoothefoobarman", b));
    }

}
