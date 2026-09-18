import java.io.*;
import java.util.*;

class Solution {
    private static final int[][] DYDX = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private static int[][] arr;
    private static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];

            Set<Integer> set = new HashSet<>();
            set.add(0);
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    set.add(arr[i][j]);
                }
            }

            int max = Integer.MIN_VALUE;
            for (int num : set) {
                boolean[][] visited = new boolean[n][n];
                int cnt = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] > num && !visited[i][j]) {
                            visited[i][j] = true;
                            dfs(i, j, num, visited);
                            cnt++;
                        }
                    }
                }
                max = Math.max(max, cnt);
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int y, int x, int num, boolean[][] visited) {
        for (int d = 0; d < 4; d++) {
            int ny = y + DYDX[d][0];
            int nx = x + DYDX[d][1];

            if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                continue;
            if (!visited[ny][nx] && arr[ny][nx] > num) {
                visited[ny][nx] = true;
                dfs(ny, nx, num, visited);
            }
        }
    }
}