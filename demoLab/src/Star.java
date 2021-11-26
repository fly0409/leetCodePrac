public class Star {
    public static void main(String[] args) {
        int n = 13;
        for (int i = 0; i < n; i++) {
            for (int j = (n/2-i)>0?(n/2-i):(i-n/2); j < n/2; j++) {
                System.out.print(" ");
            }
            for (int j = (n-(i*2))>0?(n-(i*2)):((i*2)-n)+2; j>0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
