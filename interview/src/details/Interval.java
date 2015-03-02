package details;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Test;

import Util.Print;

public class Interval {
    int s;
    int e;
    public Interval() {}
    @Override public boolean equals(Object v) {
        Interval o = (Interval) v;
        return s == o.s && e == o.e;
    }
    @Override public String toString() {
        return "(" + String.valueOf(s) + " " + String.valueOf(e) + ")";
    }
    public static void insert(LinkedList<Interval> v, Interval a) {
        int i = 0;
        Iterator<Interval> x = v.iterator();
        while (x.hasNext()) {
            Interval b = x.next();
            System.out.println(b + " " + a + " "  + i);
            Print.log(v);
            if (a.e < b.s) {
                v.add(i, a);
                return;
            } else if (a.s > b.e) {
                ++i;
                continue;
            } else {
                a.s = Math.min(a.s, b.s);
                a.e = Math.max(a.e, b.e);
                // remove invalidates iterator
                v.remove(i);
                x = v.listIterator(i);
            }
        }
        v.addLast(a);
    }

    public static LinkedList<Interval> insert(LinkedList<Interval> v) {
        LinkedList<Interval> r = new LinkedList<Interval>();
        for (Interval b : v) {
            insert(r, b);
        }
        return r;
    }

    public static Interval getInterval(int s, int e) {
        Interval i = new Interval();
        i.s = s;
        i.e = e;
        return i;
    }
    @Test
    public void test() {
        Interval i1 = getInterval(1, 3);
        Interval i2 = getInterval(6, 9);
        Interval i3 = getInterval(2, 5);
        Interval i4 = getInterval(1, 5);
        Interval i5 = getInterval(1, 2);
        Interval i6 = getInterval(3, 5);
        Interval i7 = getInterval(6, 7);
        Interval i8 = getInterval(8, 10);
        Interval i9 = getInterval(12, 16);
        Interval i10 = getInterval(4, 9);
        Interval i11 = getInterval(3, 10);
        Interval i12 = getInterval(15, 18);
        Interval i13 = getInterval(2, 6);
        Interval i14 = getInterval(1, 6);
        Interval a1[] = {i1, i2};
        Interval b1[] = {i4, i2};
        LinkedList<Interval> c1 = new LinkedList<Interval>(Arrays.asList(a1));
        LinkedList<Interval> d1 = new LinkedList<Interval>(Arrays.asList(b1));
        //insert(c1, i3);
        //Print.log(c1);
        //Assert.assertEquals(c1,d1);
        
        Interval a2[] = {i5, i6, i7, i8, i9};
        Interval b2[] = {i5, i11, i9};
        LinkedList<Interval> c2 = new LinkedList<Interval>(Arrays.asList(a2));
        LinkedList<Interval> d2 = new LinkedList<Interval>(Arrays.asList(b2));
        insert(c2, i10);
        Print.log(c2);
        Assert.assertEquals(c2,d2);
        
        Interval a3[] = {i1, i13, i8, i12};
        Interval b3[] = {i14, i8, i12};
        LinkedList<Interval> c3 = new LinkedList<Interval>(Arrays.asList(a3));
        LinkedList<Interval> d3 = new LinkedList<Interval>(Arrays.asList(b3));
        LinkedList<Interval> r = insert(c3);
        Assert.assertEquals(r,d3);
    }

}
