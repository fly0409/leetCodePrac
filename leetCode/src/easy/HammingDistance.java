package easy;

import java.util.Arrays;

public class HammingDistance {

    public static int hammingDistance(int x, int y){
        int xor = x^y;
        int ans=0;
        for (int i = 0; i < 32; i++) {
            if(((1<<i) & xor)>0){
                ans++;
            }
        }
        return ans;
    }

    public static int hammingDistance2(int x, int y) {

        int[] arrX = toBitArr(x);
        int[] arrY = toBitArr(y);
        int ans = 0;
        for (int i = 0; i < arrX.length ; i++) {
            if (arrX[i] != arrY[i]){
                ans++;
            }
        }
        return ans;
    }
    public static int[] toBitArr(int x){
        int[] binaryX = new int[31];
        if(x==0){
            return binaryX;
        }
        int cursor=0;
        while (x / 2 > 0){
            binaryX[cursor] = x%2;
            cursor++;
            x=x/2;
        }
        binaryX[cursor]=1;
        return binaryX;
    }



    public static void main(String[] args) {
//        System.out.println(Arrays.toString(toBitArr(0)));
        System.out.println(hammingDistance(16,15));
    }
}
