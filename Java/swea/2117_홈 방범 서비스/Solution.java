import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][n];
            List<int[]> houses = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        houses.add(new int[] { i, j });
                    }
                }
            }

            int res = 0;
            for (int k = 1; k <= n + 1; k++) {
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < n; x++) {
                        int cnt = 0;

                        for (int[] house : houses) {
                            int dist = Math.abs(y - house[0]) + Math.abs(x - house[1]);
                            if (dist < k) {
                                cnt++;
                            }
                        }

                        int profit = (cnt * m) - (k * k + (k - 1) * (k - 1));
                        if (profit >= 0) {
                            res = Math.max(res, cnt);
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }
}