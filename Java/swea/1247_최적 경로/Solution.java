import java.io.*;
import java.util.*;

class Solution {
    private static int[][] customers;
    private static boolean[] visited;

    private static int startX, startY, endX, endY;
    private static int n, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            visited = new boolean[n];
            customers = new int[n][2];
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                customers[i][0] = x;
                customers[i][1] = y;
            }

            min = Integer.MAX_VALUE;
            dfs(0, startX, startY, 0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int cnt, int x, int y, int sum) {
        if (sum >= min) {
            return;
        }

        if (cnt == n) {
            min = Math.min(min, sum + Math.abs(x - endX) + Math.abs(y - endY));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            int d = Math.abs(customers[i][0] - x) + Math.abs(customers[i][1] - y);
            dfs(cnt + 1, customers[i][0], customers[i][1], sum + d);
            visited[i] = false;
        }
    }
}