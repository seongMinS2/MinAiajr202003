package ex;

public class RuntimExceptionCase {
    public static void main(String[] args) {

            try {
                int[] arr = new int[3];
                arr[3] = 20;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
//
        try {
            Object obj = new int[10];
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            int[] ar = new int[-10];
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            String str = null;
            int len = str.length();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
