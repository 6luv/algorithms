import java.io.*;
import java.util.*;

class Solution {
    private static int n, b, res;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            res = Integer.MAX_VALUE;
            bt(0, 0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static void bt(int idx, int height) {
        if (height >= b) {
            res = Math.min(res, height - b);
            return;
        }

        if (idx == n) {
            return;
        }

        bt(idx + 1, height);
        bt(idx + 1, height + arr[idx]);
    }
}