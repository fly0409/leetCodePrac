package medium;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0}, {1, 0, 1, 0}, {1, 1, 0, 1}, {0, 0, 0, 0}};
//        int[][] grid = new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
//        int[][] grid = new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
        int res = shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        // check input
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        //end of check input

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] alreadyStepped = new boolean[row][col];

        alreadyStepped[0][0] = true;

        queue.offer(new int[]{0, 0});
        int ans = 0;
        //queue還有東西,表示還有路可以走
        while (!queue.isEmpty()) {

            ans++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentPosition = queue.poll();
                assert currentPosition != null;
                if (currentPosition[0] == row - 1 && currentPosition[1] == col - 1) {
                    return ans;
                }

                for (int[] direction : directions) {
                    int x = currentPosition[0] + direction[0];
                    int y = currentPosition[1] + direction[1];

                    //8個方向都走走看,
                    //  如果走不通,就往下一個方向,
                    //  如果走得通,就把那一點當作已走過,並且把那一點加入queue裡面
                    if (x < 0 || x > row - 1 || y < 0 || y > col - 1 || grid[x][y] == 1 || alreadyStepped[x][y]) {
                        continue;
                    }
                    alreadyStepped[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return -1;
    }
}
