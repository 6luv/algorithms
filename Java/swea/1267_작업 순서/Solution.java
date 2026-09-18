import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int[] indegree = new int[v + 1];
            List<List<Integer>> arr = new ArrayList<>();
            for (int i = 0; i < v + 1; i++) {
                arr.add(new ArrayList<Integer>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < e; i++) {
                int c1 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());

                arr.get(c1).add(c2);
                indegree[c2]++;
            }

            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= v; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            sb.append("#").append(tc).append(" ");
            while (!queue.isEmpty()) {
                int current = queue.poll();
                sb.append(current).append(" ");

                for (int node : arr.get(current)) {
                    indegree[node]--;
                    if (indegree[node] == 0) {
                        queue.offer(node);
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}