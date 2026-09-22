import java.io.*;
import java.util.*;

class Solution {
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= 100; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n / 2; i++) {
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.get(s).add(d);
            }

            int max = bfs(k);
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    private static int bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        boolean[] visited = new boolean[101];
        visited[start] = true;

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int c : graph.get(current)) {
                    if (visited[c])
                        continue;

                    queue.offer(c);
                    visited[c] = true;
                }
            }

            if (!queue.isEmpty()) {
                res = Collections.max(queue);
            }
        }

        return res;
    }
}