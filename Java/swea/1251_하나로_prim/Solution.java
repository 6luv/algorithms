import java.io.*;
import java.util.*;

class Solution {
    private static int n;
    private static Node[] adjList;
    private static boolean[] visited;
    private static double[] minEdge;

    static class Node {
        int to;
        double weight;
        Node next;

        public Node(int to, double weight, Node next) {
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
            n = Integer.parseInt(br.readLine());

            adjList = new Node[n];
            visited = new boolean[n];
            minEdge = new double[n];

            int[][] info = new int[n][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    info[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            double e = Double.parseDouble(br.readLine());

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    double x = info[i][0] - info[j][0];
                    double y = info[i][1] - info[j][1];
                    double l = x * x + y * y;

                    adjList[i] = new Node(j, l, adjList[i]);
                    adjList[j] = new Node(i, l, adjList[j]);
                }
            }

            Arrays.fill(minEdge, Double.MAX_VALUE);
            double result = 0;
            minEdge[0] = 0;

            int c;
            for (c = 0; c < n; c++) {
                double min = Double.MAX_VALUE;
                int minVertex = -1;

                for (int i = 0; i < n; i++) {
                    if (!visited[i] && minEdge[i] < min) {
                        min = minEdge[i];
                        minVertex = i;
                    }
                }

                if (minVertex == -1)
                    break;

                result += min;
                visited[minVertex] = true;

                for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
                    if (!visited[temp.to] && minEdge[temp.to] > temp.weight) {
                        minEdge[temp.to] = temp.weight;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(Math.round(result * e)).append("\n");
        }

        System.out.print(sb);
    }
}