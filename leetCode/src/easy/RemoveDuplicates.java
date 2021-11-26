package easy;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int temp;

        while (right<nums.length){
            if(nums[left]==nums[right]&&left==right){
                if(right+1<nums.length){//避免index out of bound
                    right++;
                }

            }

            if(nums[right]>nums[left]){
                left++;
                temp = nums[right];
                nums[left]=temp;
            }else if(nums[right]==nums[left]){
                //找到下個比left大的
                right++;
            }else{
                System.out.println("GG");
            }

        }
        System.out.println(left);
        System.out.println(right);
        System.out.println(Arrays.toString(nums));




        return left+1;
    }
       // 簡化的寫法
//    public int removeDuplicates(int[] nums) {
//        if(nums.length == 0){
//            return 0;
//        }
//
//        int j= 0;
//        for(int i=1 ; i<nums.length ; i++){
//            if(nums[j] != nums[i]){
//                nums[++j] = nums[i];
//            }
//        }
//        return j+1;
//    }

    public static void main(String[] args) {
        int[] nums = {3};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
