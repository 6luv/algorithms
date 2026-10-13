import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n + 1][k + 1];
            int[][] info = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                info[i][0] = v;
                info[i][1] = c;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (info[i][0] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - info[i][0]] + info[i][1], dp[i - 1][j]);
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(dp[n][k]).append("\n");
        }

        System.out.print(sb);
    }
}