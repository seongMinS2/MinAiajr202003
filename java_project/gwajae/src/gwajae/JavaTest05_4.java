package gwajae;

public class JavaTest05_4 {
    public static void main(String[] args) {
//[4] 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100이상이되는지 구하시오.

        int sum = 0;
        int count = 0;
        for(int i = 0; i<1000; i++){
            if(sum <= 100) {
                if (i % 2 != 0) {
                    sum += i;
                    count++;
                } else if (i % 2 == 0) {
                    sum -= i;
                    count++;
                }
            }else{
                break;
            }
            System.out.println("총합이 100일때까지 더한 횟수: " + count);
        }

    }
}
