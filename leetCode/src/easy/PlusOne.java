package easy;

import java.sql.Array;
import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >=0; i--) {
            if(digits[i]+1<10){
                digits[i] = digits[i]+1;
                break;
            }else{
                if(i > 0){
                    digits[i]=0;
                    continue;
                }else if (i==0){
                    int[] digit2 = new int[digits.length+1];
                    digit2[0]=1;
                    digits=digit2;
                    break;
                }
            }

        }



        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));

    }

}
