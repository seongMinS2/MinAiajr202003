package card;

public class CardMain2 {
    public static void main(String[] args) {
        for(int i=0; i<4; i++) {
            for (int x = 1; x < 14; x++) {
                String kind = "";
                switch (i) {
                    case 0:
                        kind = "spade";
                        break;
                    case 1:
                        kind = "Clover";
                        break;
                    case 2:
                        kind = "Heart";
                        break;
                    case 3:
                        kind = "Diamond";
                        break;
                }
                System.out.println("카드는 " + kind + "\t번호는 " + x);

            }
        }
    }
}
