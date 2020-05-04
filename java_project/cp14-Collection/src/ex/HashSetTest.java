package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {

        //HashSet<String> set = new HashSet<String>();
        //HashSet<String> set = new HashSet<>();
        Set<SimpleNumber> set = new HashSet<>();

        set.add(new SimpleNumber(10));
        set.add(new SimpleNumber(20));
        set.add(new SimpleNumber(30));
        set.add(new SimpleNumber(10));

        System.out.println("저장된 데이터의 개수 : " + set.size());
        for(SimpleNumber e : set){
            System.out.println(e);
        }

        Iterator<SimpleNumber> itr = set.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next().hashCode());
        }


    }
}
