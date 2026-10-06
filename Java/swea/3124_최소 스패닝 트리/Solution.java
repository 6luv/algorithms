import java.io.*;
import java.util.*;

class Solution {
    private static int v;
    private static int e;

    private static int[] parents;
    private static Edge[] edgeList;

    public static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            super();

            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Long.compare(this.weight, e.weight);
        }
    }

    private static void makeSet() {
        for (int i = 0; i < v; i++) {
            parents[i] = -1;
        }
    }

    private static int find(int a) {
        if (parents[a] <= 0) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        if (parents[aRoot] <= parents[bRoot]) { // 작은 쪽이 크기가 큼
            parents[aRoot] += parents[bRoot];
            parents[bRoot] = aRoot;
        } else {
            parents[bRoot] += parents[aRoot];
            parents[aRoot] = bRoot;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            parents = new int[v];
            edgeList = new Edge[e];

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());

                edgeList[i] = new Edge(from, to, weight);
            }

            Arrays.sort(edgeList);
            makeSet();

            long result = 0;
            int cnt = 0;

            for (Edge edge : edgeList) {
                if (union(edge.from, edge.to)) {
                    result += edge.weight;

                    if (++cnt == v - 1) {
                        break;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }
}
