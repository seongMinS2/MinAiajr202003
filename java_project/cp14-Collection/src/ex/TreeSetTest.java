package ex;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {

        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(1);
        ts.add(2);
        ts.add(4);
        ts.add(3);
        ts.add(1);
        ts.add(2);

        System.out.println("요소의 개수: " + ts.size());

        Iterator ite = ts.iterator();

        while(ite.hasNext()){
            System.out.println(ite.next());
        }
    }
}
