package gwajae;

public class JavaTest04_12 {
    public static void main(String[] args) {

        int i = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            i++;
            if (i % 6 == 0) {
                System.out.println("6의 배수 : " + i);
                sum += i;
                count++;
                System.out.println("카운트: " + count);
            }
            else if ((i % 2 != 0)) {
                System.out.println("홀수 : " + i);
                sum += i;
                count++;
                System.out.println("카운트: " + count);
            }
            if (i == 1000) {
                System.out.println("1000까지의 합" + sum);
                System.out.println("1000이 됬을때 몇번 더했는지? : " + count);
                break;
            }

        }
    }
}
