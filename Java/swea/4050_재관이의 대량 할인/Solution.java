import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[] costs = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(costs);
            int sum = Arrays.stream(costs).sum();

            for (int i = costs.length - 1; i >= 2; i -= 3) {
                int cost1 = costs[i];
                int cost2 = costs[i - 1];
                int cost3 = costs[i - 2];

                sum -= Math.min(cost1, Math.min(cost2, cost3));
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }
}