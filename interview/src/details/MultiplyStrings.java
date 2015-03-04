package details;

import java.util.Vector;

import junit.framework.Assert;

import org.junit.Test;

public class MultiplyStrings {
    public static final int MAXSTRSIZE = 9;
    public static final int MAXSTRVALUE = 1000000000;
    public static Vector<Long> toVectorLong(String s) {
        int len = s.length()/MAXSTRSIZE + ((s.length() % MAXSTRSIZE) > 0?1:0);
        //System.out.println(s.length() + " " + len);
        Vector<Long> r = new Vector<Long>(len);
        for (int i = 0; i < len; ++i) {
            String a = s.substring(i*MAXSTRSIZE, Math.min(s.length()+1, (i+1)*MAXSTRSIZE));
            long l = Long.valueOf(a);
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
        for(int i = 0; i < a.size(); ++i) {
            for (int j = 0; j < b.size(); ++j){
                long c = a.elementAt(i) * b.elementAt(j);
                long d = c % MAXSTRVALUE;
                Long e = r.elementAt(i+j);
                e += d;
                if (c > MAXSTRVALUE) {
                    Long f = r.elementAt(i+j+1);
                    f += (c / MAXSTRVALUE);
                }
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
        Assert.assertEquals("144", multiply("12","12"));
        Assert.assertEquals("999999998000000001", multiply("999999999","999999999"));
        Assert.assertEquals("899999999991", multiply("9","99999999999"));
        Assert.assertEquals("899999999991", multiply("99999999999", "9"));
        Assert.assertEquals("1864711849423024129", multiply("99999999999", "99999999999"));        
    }

}
