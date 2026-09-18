import java.io.*;
import java.util.*;

class Solution {
    private static final int[][] DYDX = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    private static final int SIZE = 100;

    private static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            arr = new char[SIZE][];

            for (int i = 0; i < SIZE; i++) {
                char[] line = br.readLine().toCharArray();
                arr[i] = line;
            }

            boolean res = bfs();
            sb.append("#").append(tc).append(" ").append(res ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean bfs() {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 1, 1 });

        boolean[][] visited = new boolean[SIZE][SIZE];
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (arr[current[0]][current[1]] == '3') {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int ny = current[0] + DYDX[d][0];
                int nx = current[1] + DYDX[d][1];

                if (!isInRange(ny, nx))
                    continue;
                if (!visited[ny][nx] && arr[ny][nx] != '1') {
                    visited[ny][nx] = true;
                    queue.offer(new int[] { ny, nx });
                }
            }
        }

        return false;
    }

    private static boolean isInRange(int ny, int nx) {
        return 0 <= ny && ny < SIZE && 0 <= nx && nx < SIZE;
    }
}