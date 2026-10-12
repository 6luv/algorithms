import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int[] costs = new int[4];
            int[] plans = new int[13];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plans[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[13];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 1; i <= 12; i++) {
                int p1 = dp[i - 1] + (plans[i] * costs[0]);
                int p2 = dp[i - 1] + costs[1];

                dp[i] = Math.min(p1, p2);

                if (i >= 3) {
                    int p3 = dp[i - 3] + costs[2];
                    dp[i] = Math.min(dp[i], p3);
                }
            }

            dp[12] = Math.min(dp[12], costs[3]);
            sb.append("#").append(tc).append(" ").append(dp[12]).append("\n");
        }

        System.out.print(sb);
    }
}