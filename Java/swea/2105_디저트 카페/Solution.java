import java.io.*;
import java.util.*;

class Solution {
    private static final int[][] DYDX = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };

    private static int[][] map;
    private static boolean[] visited;
    private static int n, max, startY, startX;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = -1;
            visited = new boolean[101];
            for (int i = 0; i < n - 2; i++) {
                for (int j = 1; j < n - 1; j++) {
                    startY = i;
                    startX = j;

                    visited[map[i][j]] = true;
                    dfs(i, j, 0, 1);
                    visited[map[i][j]] = false;
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int y, int x, int d, int cnt) {
        for (int dir = d; dir <= Math.min(d + 1, 3); dir++) {
            int ny = y + DYDX[dir][0];
            int nx = x + DYDX[dir][1];

            if (startX == nx && startY == ny) {
                if (dir == 3) {
                    max = Math.max(max, cnt);
                    return;
                }
            }

            if (!isInRange(ny, nx) || visited[map[ny][nx]])
                continue;

            visited[map[ny][nx]] = true;
            dfs(ny, nx, dir, cnt + 1);
            visited[map[ny][nx]] = false;
        }
    }

    private static boolean isInRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}