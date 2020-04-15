package gwajae;

public class JavaTest04_13 {
    public static void main(String[] args) {

        int k = 10;
        for(int i=2; i<10; i++){
            System.out.println("---------------------------");
            for(int j=1; j<k; j++){
                if(i%2!=0){
                    continue;
                }
                if(i==2){
                    k=2;
                } else if(i==4){
                    k=5;
                } else if(i==8){
                    k=9;
                } else{
                    k=10;
                }
                System.out.println(i + "*" + j + "=" + (i*j));
            }
        }
    }
}
