package medium;

public class HouseRobber {
    //https://leetcode.com/problems/house-robber/
    public static int rob(int[] nums) {
        int[] dpArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(i==0||i==1){
                dpArr[i]= nums[i];
            }else{
                int max = 0;
                //(i-3)>0?(i-3):0
                for (int j =(i-2)>0?(i-2):0; j < i-1; j++) {
                    max = Math.max(max,dpArr[j]);
                    System.out.println("i:"+i+",j:"+j+",max:"+max);
                    dpArr[i] = nums[i]+max;
                }
            }

        }
        int ans = 0;
        for (int i = 0; i <dpArr.length ; i++) {
            System.out.println(dpArr[i]);
            ans = Math.max(ans,dpArr[i]);

        }


        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
        int[] nums = {2,7,9,3,1};

        System.out.println(rob(nums));
    }
}
