package gwajae;

public class JavaTest04_11 {
    public static void main(String[] args) {

        int num=0;
        int count=0;
//        while((num++)<100){
//            if(num%5!=0 || num%7!=0)
//                continue;
//            count++;
//            System.out.println(num);
//        }
//        System.out.println("count: " + count);

        for(num=1; num<100; num++){
            if(num%5!=0 || num%7!=0)
                continue;
            count++;
            System.out.println(num);
        }
        System.out.println("count: " + count);

    }
}
