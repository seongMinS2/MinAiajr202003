package ex;


import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {

        // List<E> -> ArrayList<E>
        // List<E> : 저장 순서를 가진다. 데이터의 중복 저장 가능
        // 순서 -> 일괄 처리(반복적인 동일한 작업을 빠르게 처리)

        // ArrayList 인스턴스 생성 : Integer 타입의 객체만 저장
        //ArrayList<Integer> list = new ArrayList<Integer>();
        //ArrayList<Integer> list = new ArrayList<>();

        //ArrayList<Integer> list = new ArrayList<Integer>();

        LinkedList<Integer> list = new LinkedList<Integer>();


        // List<E> 정의된 메서드 -->
        // add() : 인스턴스의 저장
        // remove(index) : 해당 index의 요소를 삭제
        // size() : List 요소의 개수를 반환
        // get(index) : 해당 index위치의 요소 반환

        //데이터의 저장
        list.add(new Integer(30));
        list.add(new Integer(20));
        list.add(new Integer(10));

        System.out.println("저장된 데이터를 확인합니다.");

        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("------------------");


        //데이터의 삭제
        System.out.println("삭제 후 데이터를 확인합니다.");

//        list.remove(1);
//
//        for (int i=0; i<list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        Iterator<Integer> itr = list.iterator();

        while(itr.hasNext()){
            int num = itr.next();
            System.out.println(num);
        }

    }
}
