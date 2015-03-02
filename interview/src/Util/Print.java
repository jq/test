package Util;
import java.util.List;


public class Print {
    public static <E> void log(List<E> l) {
        for (E e : l) {
            System.out.print(e.toString() + " ");
        }
        System.out.println("");
    }

}
