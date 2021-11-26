package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedinArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = i+1;
        }

        for (int i = 0; i < nums.length; i++) {
           temp[nums[i]-1] = 0;
        }

        for (int i = 0; i < temp.length; i++) {
            if(temp[i]!=0){
                arr.add(temp[i]);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};

        List<Integer> res = findDisappearedNumbers(nums);
        for (Integer n :res) {
            System.out.print(n+",");
        }
    }
}
