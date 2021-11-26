package easy;

public class Sqrt {
    public static int mySqrt(int x) {
        int upper = 1;
        while (x>=upper*upper){
            upper +=1;
            if(upper>46340){
                upper=46340;
               return upper;
            }
        }
        return upper-1;
    }
    //binary search
    public static int mySqrt2(int x) {
        if(x==0){
            return 0;
        }

        int left = 1; int right = x;
        int mid = 0;
        while (true){
            mid = left+(right-left)/2;
            if(mid > x/mid){
                right = mid -1;
            }else{
                if(mid+1 >x/(mid+1)){
                    return mid;
                }else {
                    left=mid +1;
                }
            }

        }
    }


    public static void main(String[] args) {
        System.out.println(mySqrt2(2147395599));
    }
}
