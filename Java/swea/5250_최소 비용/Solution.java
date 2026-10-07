import java.io.*;
import java.util.*;

class Solution {
    private static int[] DY = { -1, 1, 0, 0 };
    private static int[] DX = { 0, 0, -1, 1 };
    private static int[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
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

            int min = dijkstra();
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }

    private static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { 0, 0, 0 });

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int cost = cur[0];
            int y = cur[1];
            int x = cur[2];

            if (y == n - 1 && x == n - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (isInRange(ny, nx) && !visited[ny][nx]) {
                    int nextCost = cost + Math.max(map[ny][nx] - map[y][x], 0) + 1;
                    if (nextCost < dist[ny][nx]) {
                        dist[ny][nx] = nextCost;
                        pq.offer(new int[] { nextCost, ny, nx });
                    }
                }
            }
        }

        return dist[n - 1][n - 1];
    }

    private static boolean isInRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}