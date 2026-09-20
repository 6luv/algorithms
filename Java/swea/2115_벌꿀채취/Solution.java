import java.io.*;
import java.util.*;

class Solution {
    private static int[][] map, profit;
    private static int n, m, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            makeProfit();
            int max = findMaxProfit();

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    private static void makeProfit() {
        profit = new int[n][n - m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - m + 1; j++) {
                profit[i][j] = getProfit(i, j);
            }
        }
    }

    private static int getProfit(int y, int x) {
        int max = 0;

        for (int mask = 0; mask < (1 << m); mask++) {
            int honey = 0;
            int value = 0;

            for (int k = 0; k < m; k++) {
                if ((mask & (1 << k)) != 0) {
                    int current = map[y][x + k];

                    honey += current;
                    value += current * current;
                }
            }

            if (honey <= c) {
                max = Math.max(max, value);
            }
        }

        return max;
    }

    private static int findMaxProfit() {
        int max = 0;

        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n - m + 1; j1++) {

                for (int i2 = i1; i2 < n; i2++) {
                    int startJ = 0;

                    if (i1 == i2) {
                        startJ = j1 + m;
                    }

                    for (int j2 = startJ; j2 < n - m + 1; j2++) {
                        max = Math.max(max, profit[i1][j1] + profit[i2][j2]);
                    }
                }
            }
        }

        return max;
    }
}