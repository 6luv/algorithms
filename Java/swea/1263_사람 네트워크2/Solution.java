import java.io.*;
import java.util.*;

class Solution {
    private static int n, min;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            graph = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                bfs(i);
            }

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int v) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[v] = 0;

        int sum = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int j = 1; j <= n; j++) {
                if (graph[cur][j] == 1 && dist[j] == -1) {
                    dist[j] = dist[cur] + 1;
                    queue.offer(j);
                    sum += dist[j];

                    if (sum >= min) {
                        return;
                    }
                }
            }
        }

        min = Math.min(min, sum);
    }
}