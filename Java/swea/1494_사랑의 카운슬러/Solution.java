
import java.io.*;
import java.util.*;

class Solution {

    private static long min;
    private static int n;
    private static int[][] info;
    private static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            info = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                info[i][0] = Integer.parseInt(st.nextToken());
                info[i][1] = Integer.parseInt(st.nextToken());
            }

            min = Long.MAX_VALUE;
            selected = new boolean[n];
            bt(0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

    private static void bt(int idx, int cnt) {
        if (cnt == n / 2) {
            long sumX = 0;
            long sumY = 0;

            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    sumX += info[i][0];
                    sumY += info[i][1];
                } else {
                    sumX -= info[i][0];
                    sumY -= info[i][1];
                }
            }

            long res = sumX * sumX + sumY * sumY;
            min = Math.min(min, res);
            return;
        }

        if (idx == n) {
            return;
        }

        selected[idx] = true;
        bt(idx + 1, cnt + 1);

        selected[idx] = false;
        bt(idx + 1, cnt);
    }
}
