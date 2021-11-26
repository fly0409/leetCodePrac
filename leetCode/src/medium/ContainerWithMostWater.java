package medium;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max = 0;
        int front = 0;
        int end = height.length-1;
        while ( front<end){
            max = Math.max(max, Math.min(height[front], height[end])
                    * (end - front));
            if (height[front] > height[end]){
                end--;
            }else{
                front++;
            }
        }
        return max;
    }

    //用DP解 但是費時太久
//    public static int maxArea(int[] height) {
//        int n = height.length;
//        int[] dp = new int[n];
//        int currentMax = 0;
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if(height[i]<height[j]){
//                    currentMax = height[i]*(i-j);
//                }else {
//                    currentMax = height[j]*(i-j);
//                }
//                max = Math.max(max,currentMax);
//            }
//            dp[i] = max;
//        }
//        int ans = 0;
//        for(int h : dp){
//            ans = Math.max(ans,h);
//        }
////        System.out.println(Arrays.toString(dp));
//        return ans;
//    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,2};
//        int[] height = {1,2,1};
        System.out.println(maxArea(height));
     }
}
