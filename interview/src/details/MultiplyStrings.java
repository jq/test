package details;

import java.util.Collections;
import java.util.Vector;

import junit.framework.Assert;

import org.junit.Test;

public class MultiplyStrings {
    public static final int MAXSTRSIZE = 9;
    public static final int MAXSTRVALUE = 1000000000;
    public static String reverse(final String a) {
        return new StringBuilder(a).reverse().toString();
    }
    public static Vector<Long> toVectorLong(final String a) {
        int len = a.length()/MAXSTRSIZE + ((a.length() % MAXSTRSIZE) > 0?1:0);
        //System.out.println(s.length() + " " + len);
        Vector<Long> r = new Vector<Long>(len);
        String s = reverse(a);
        for (int i = 0; i < len; ++i) {
            String b = s.substring(i*MAXSTRSIZE, Math.min(s.length(), (i+1)*MAXSTRSIZE));
            long l = Long.valueOf(reverse(b));
            System.out.println(l);
            r.add(l);
        }
        return r;
    }
    public static void addMultiChar(StringBuilder sb, char c, int size) {
        for(int i = 0; i < size; i++) {
            sb.append(c);
        }
    }
    public static String vectorToStr(Vector<Long> v) {        
        Collections.reverse(v);
        StringBuilder sb = new StringBuilder(v.size() * MAXSTRSIZE);
        for(int i = 0; i < v.size(); i++) {
            String s = v.elementAt(i).toString();
            if (i != 0) {
                addMultiChar(sb, '0', MAXSTRSIZE- s.length());
            }
            sb.append(s);
        }
        return sb.toString();            
    }
    public static Vector<Long> vectorMultiply(Vector<Long> a, Vector<Long> b) {
        Vector<Long> r = new Vector<Long>(a.size()+b.size());
        for (int i = 0; i < a.size()+b.size(); ++i) {
            Long l = new Long(0);
            r.add(l);
        }
        //Collections.reverse(a);
        //Collections.reverse(b);
        for(int i = 0; i < a.size(); ++i) {
            for (int j = 0; j < b.size(); ++j){
                long c = a.elementAt(i) * b.elementAt(j);
                long d = c % MAXSTRVALUE;
                long e = r.elementAt(i+j);
                e += d;
                System.out.println((i+j) + " c " + c+ " d " + d + " e " + e + " r " + r.elementAt(i+j));
                r.set(i+j, e);
                if (c > MAXSTRVALUE) {
                    long f = r.elementAt(i+j+1);
                    f += (c / MAXSTRVALUE);
                    System.out.println((i+j+1) + " f " + f + " c " + c/MAXSTRVALUE + " r " + r.elementAt(i+j+1));
                    r.set(i+j+1, f);
                }
            }
        }
        // + will overflow as well, so now scan all to fix it.
        for (int i = 0; i < r.size()-1; ++i) {
            long c = r.elementAt(i);
            if (c > MAXSTRVALUE) {
                long d = c % MAXSTRVALUE;
                r.set(i, d);
                long f = r.elementAt(i+1);
                f += (c / MAXSTRVALUE);
                System.out.println("new " + (i+1) + " f " + f + " c " + c/MAXSTRVALUE + " r " + r.elementAt(i+1));
                r.set(i+1, f);
            }
        }
        if (r.lastElement() == 0) {
            r.remove(r.size()-1);
        }
        return r;
    }
    public static String multiply(String a, String b) {
        return vectorToStr(vectorMultiply(toVectorLong(a), toVectorLong(b)));
    }
    @Test
    public void test() {
        Assert.assertEquals("999999998000000001", vectorToStr(toVectorLong("999999998000000001")));
        Assert.assertEquals("999999900000000001", vectorToStr(toVectorLong("999999900000000001")));

        Assert.assertEquals("0", multiply("0","1"));
        Assert.assertEquals("152399025", multiply("12345","12345"));
        Assert.assertEquals("999999998000000001", multiply("999999999","999999999"));
        Assert.assertEquals("899999999991", multiply("9","99999999999"));
        Assert.assertEquals("899999999991", multiply("99999999999", "9"));
        // 9999,999999800,000000001
        Assert.assertEquals("9999999999800000000001", multiply("99999999999", "99999999999"));
        Assert.assertEquals("99999999996000000000059999999999600000000001", multiply("9999999999800000000001", "9999999999800000000001"));        

    }

}
