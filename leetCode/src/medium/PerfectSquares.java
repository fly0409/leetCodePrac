package medium;

import java.util.*;

//https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {

    public static void main(String[] args) {
//        int ans = numSquaresBFS(17);
        int ans = numSquaresDP(17);
        System.out.println(ans);
    }

    public static int numSquaresBFS(int n) {
        //BFS 解法
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> squares = generateSquares(n);
        boolean[] isCheck = new boolean[n + 1];

        queue.offer(n);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                Integer curNum = queue.poll();

                for (Integer num : squares) {
                    int remain = curNum - num;
                    if (remain == 0) return ans;
                    if (remain < 0) continue;
                    if (isCheck[remain]) continue;
                    if (remain < n) {
                        isCheck[remain] = true;
                        queue.offer(remain);
                    }
                }
            }
        }
        return -1;
    }

    public static int numSquaresDP(int n) {

        /*
         * dp[0] = 0
         * dp[1] = dp[0] + 1
         * dp[2] = dp[1] + 1
         * dp[3] = dp[2] + 1
         * dp[4] = min(dp[4-1*1] +1 , dp[4-2*2] +1 ) = 1
         * dp[5] = min(dp[5-1*1] +1 , dp[5-2*2] +1 ) = 2
         */
        int[] dpArray = new int[n+1];        
        Arrays.fill(dpArray,10);
        dpArray[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j *j <= i; j++) {
                dpArray[i] = Math.min(dpArray[i], dpArray[i-j*j]+1);
            }
        }
        return dpArray[n];
    }

    //產生 比n小的所有平方數
    private static List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i < n; i++) {
            squares.add(i * i);
        }
        return squares;
    }

}
