import java.io.*;
import java.util.*;

class Solution {
    private static final int[][] DYDX = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
            { 1, 1 } };

    private static char[][] map;
    private static int[][] countMap;
    private static boolean[][] visited;
    private static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new char[n][];

            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
            }

            countMap = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*')
                        continue;

                    for (int d = 0; d < 8; d++) {
                        int ny = i + DYDX[d][0];
                        int nx = j + DYDX[d][1];

                        if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                            continue;
                        if (map[ny][nx] == '*')
                            countMap[i][j]++;
                    }
                }
            }

            int cnt = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*')
                        continue;
                    if (visited[i][j] || countMap[i][j] != 0)
                        continue;

                    bfs(i, j);
                    cnt++;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != '*' && !visited[i][j]) {
                        cnt++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { y, x });
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 8; d++) {
                int ny = current[0] + DYDX[d][0];
                int nx = current[1] + DYDX[d][1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                    continue;
                if (map[ny][nx] == '*' || visited[ny][nx])
                    continue;

                visited[ny][nx] = true;
                if (countMap[ny][nx] == 0) {
                    queue.offer(new int[] { ny, nx });
                }
            }
        }
    }
}