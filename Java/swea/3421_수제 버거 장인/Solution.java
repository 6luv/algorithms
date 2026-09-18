import java.io.*;
import java.util.*;

class Solution {
    private static int n, m, cnt;
    private static boolean[] selected;
    private static int[][] worst;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            selected = new boolean[n];
            worst = new int[m][2];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                worst[i][0] = Integer.parseInt(st.nextToken());
                worst[i][1] = Integer.parseInt(st.nextToken());
            }

            cnt = (int) Math.pow(2, n);
            count(0);

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void count(int idx) {
        if (idx == n) {
            for (int i = 0; i < m; i++) {
                if (selected[worst[i][0] - 1] && selected[worst[i][1] - 1]) {
                    cnt--;
                    break;
                }
            }
            return;
        }

        selected[idx] = true;
        count(idx + 1);

        selected[idx] = false;
        count(idx + 1);
    }
}