package medium;


import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;
        //紀錄該index往回看的時候,遞增子陣列的長度
        //int[] nums = {0,1,0,3,2,3};
        //比如說走到第一個3
        //他就會看說每個比他小的j的子陣列長度，前三個都比他小，拿出前三個出來比較
        //dp[0]=>1,dp[2]=>2,dp[3]=>1，可以看到這時候這個欄位的最大子陣列長度就是dp[2]+1(本身)也就是3
        //並把它記錄了下來 dp[4] = 3

        //紀錄每個index的最大子陣列長度
        int[] dp = new int[n];
        for (int i = 0; i < nums.length; i++) {
            int max = 1;//子陣列至少包含自己，所以是1
            for (int j = 0; j < i; j++) {
                //往回頭看，如果有比當下的num[i]還小的數字，就把他的子陣列+1當作目前的最大值
                if(nums[i]>nums[j]){
                    max = Math.max(max,dp[j]+1);
                }
            }
            //紀錄當下i的最大子陣列長度,提供後續比較
            dp[i]=max;
        }

        System.out.println(Arrays.toString(dp));
        int ans =0;
        for (int i = 0; i <dp.length ; i++) {
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {0,1,0,3,2,3};
        int[] nums ={10,9,2,5,3,7,101,18,19};
        System.out.println(lengthOfLIS(nums));
    }
}
