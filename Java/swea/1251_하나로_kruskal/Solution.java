import java.io.*;
import java.util.*;

class Solution {
    private static int n;
    private static int[] parents;
    private static Edge[] edgeList;

    static class Edge implements Comparable<Edge> {
        int from, to;
        double cost;

        public Edge(int from, int to, double cost) {
            super();
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return Double.compare(this.cost, e.cost);
        }
    }

    private static void makeSet() {
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
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

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            parents = new int[n];
            edgeList = new Edge[n * (n - 1) / 2];

            int[][] info = new int[n][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    info[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int idx = 0;
            double e = Double.parseDouble(br.readLine());
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    double d = Math.pow(info[i][0] - info[j][0], 2) + Math.pow(info[i][1] - info[j][1], 2);
                    double cost = e * d;

                    edgeList[idx++] = new Edge(i, j, cost);
                }
            }

            Arrays.sort(edgeList);
            makeSet();

            double result = 0;
            int cnt = 0;

            for (int i = 0; i < n * (n - 1) / 2; i++) {
                if (union(edgeList[i].from, edgeList[i].to)) {
                    result += edgeList[i].cost;

                    if (++cnt == n - 1) {
                        break;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");
        }

        System.out.print(sb);
    }
}