import java.io.*;
import java.util.*;

class Solution {
    private static int[] costs;
    private static int[] plan;
    private static int minCost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc ++) {
            costs = new int[5];
            plan = new int[13];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 4; i ++) {
                costs[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i ++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            minCost = costs[4];
            cal(1, 0);

            sb.append("#").append(tc).append(" ").append(minCost).append("\n");
        }

        System.out.println(sb);
    }

    private static void cal(int month, int cost) {
        if (month > 12) {
            minCost = Math.min(minCost, cost);
            return;
        }

        if (cost >= minCost) {
            return;
        }

        if (plan[month] == 0) {
            cal(month + 1, cost);
        }

        cal(month + 1, cost + costs[1] * plan[month]);
        cal(month + 1, cost + costs[2]);
        cal(month + 3, cost + costs[3]);
    }
}