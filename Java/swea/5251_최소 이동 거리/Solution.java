import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int to, weight;
        Node next;

        public Node(int to, int weight, Node next) {
            super();
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Node[] adjList = new Node[n + 1];
            int[] minDist = new int[n + 1];
            boolean[] visited = new boolean[n + 1];

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int en = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                adjList[s] = new Node(en, w, adjList[s]);
            }

            Arrays.fill(minDist, Integer.MAX_VALUE);
            minDist[0] = 0;

            for (int i = 0; i < n; i++) {
                // step1. 미방문 정점 중 최단 거리의 정점 선택
                int min = Integer.MAX_VALUE;
                int cur = -1;

                for (int j = 0; j < n; j++) {
                    if (!visited[j] && min > minDist[j]) {
                        min = minDist[j];
                        cur = j;
                    }
                }

                if (cur == -1)
                    break;

                visited[cur] = true;

                if (cur == n)
                    break;

                // step2. 선택된 정점을 경유지로 하여 미방문 인접 정점들의 최단 거리 비용과 비교하여 최솟값 갱신
                for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
                    if (!visited[temp.to] && minDist[temp.to] > min + temp.weight) {
                        minDist[temp.to] = min + temp.weight;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(minDist[n]).append("\n");
        }

        System.out.print(sb);
    }
}