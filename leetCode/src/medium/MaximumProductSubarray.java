package medium;

import java.util.Arrays;
//https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int temp;
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            temp = max;
            max = Math.max(max*nums[i],Math.max(min*nums[i],nums[i]));
            min = Math.min(temp*nums[i],Math.min(min*nums[i],nums[i]));
            if(max>ans){
                ans = max;
            }

        }

        return ans;



        // 我寫的,沒有考慮到負數乘以負數會變得更大的狀況
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] =Math.max(Math.max(dp[i-1],nums[i-1])*nums[i],nums[i]);
//        }
//        System.out.println(Arrays.toString(dp));
//
//
//        int max=nums[0];
//        for (int i = 0; i < dp.length; i++) {
//            max = Math.max(max,dp[i]);
//        }
//
//        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};//,2,0,5,6};
        //int[] nums = {-2,3,-4};
        //int[] nums = {0};
        System.out.println(maxProduct(nums));
    }
}
