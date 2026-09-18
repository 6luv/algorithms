import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static int l;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc ++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            int[][] info = new int[n][2];
            for (int i = 0; i < n; i ++) {
                st = new StringTokenizer(br.readLine());
                info[i][0] = Integer.parseInt(st.nextToken());
                info[i][1] = Integer.parseInt(st.nextToken());
            }

            comb(info, 0, 0, 0);
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static void comb(int[][] info, int cnt, int score, int cal) {
        if (cal > l) return;
        if (cnt == n) {
            max = Math.max(max, score);
            return;
        }

        comb(info, cnt + 1, score + info[cnt][0], cal + info[cnt][1]);
        comb(info, cnt + 1, score, cal);
    }
}