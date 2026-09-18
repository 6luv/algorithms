import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int[] rowSum = new int[n];
            int[] colSum = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    rowSum[i] += arr[i][j];
                    colSum[j] += arr[i][j];
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = rowSum[i] + colSum[j] - arr[i][j];
                    max = Math.max(max, sum);
                }
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(max)
                    .append("\n");
        }

        System.out.println(sb);
    }
}