package medium;

public class SingleElementinaSortedArray540 {
    //參考 https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/1587318/Java-Binary-Search-or-Beats-100-or-Most-Intutive-or-Explanation-Using-Image
    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left<right){
            mid = left +(right-left)/2;

            if(nums[mid]==nums[mid+1]){
                mid = mid -1;
            }

           //確認左邊的array長度
            if((mid-left+1)%2!=0){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(singleNonDuplicate(nums));
    }
}
