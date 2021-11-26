package easy;

public class MaximumSubarray {
    /*
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
     */
    public static int maxSubArray(int[] nums) {
        int maxTotal = nums[0];
        int maxHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(maxHere+nums[i],nums[i]);
            maxTotal = Math.max(maxTotal,maxHere);
        }
        return maxTotal;

    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
}
