package easy;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1]){
            return nums.length;
        }else if(target <nums[0]){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if(target==nums[i]){
                return i;
            }else if(i+1< nums.length && nums[i]<target && target<nums[i+1]){
                return i+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }

}
