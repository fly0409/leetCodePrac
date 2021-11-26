public class Combination {
    public static void main(String[] args) {
        int n = 10;
        int k = 6 ;
        int ans=1;
        for (int i = n+k-1; i >n-1 ; i--) {
            ans *=i;
        }
        System.out.println(ans);
        for (int i = k; i >0 ; i--) {
            ans/=i;
        }
//        System.out.println(ans);
//        for (int i = n-1; i >0 ; i--) {
//            ans/=i;
//        }

        System.out.println(ans);
    }
}
