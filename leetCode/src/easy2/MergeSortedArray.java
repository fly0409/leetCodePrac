package easy2;

import java.util.Arrays;
//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int cursor1=0;
        int cursor2=0;
        int[] result = new int[m+n];
        if(n==0) return;
        for (int i = 0; i < result.length; i++) {
              //cursor2往前跑
              if(cursor2<n && (nums1[cursor1]>nums2[cursor2] || (nums1[cursor1]<=nums2[cursor2]&&cursor1>m-1))){
//                System.out.println("2:"+cursor2);
                result[i] = nums2[cursor2];
                cursor2++;
              }else {
//                System.out.println("1:"+cursor1);
                result[i] = nums1[cursor1];
                cursor1++;
              }
        }
        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
        int[] nums1 = {1,0};
        int m = 1;
//        int[] nums2 = {2,5,6};
        int[] nums2 = {2};
        int n = 1;

        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
