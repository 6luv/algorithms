import java.io.*;

class Solution {
    private static int n;
    private static boolean[] v1;
    private static boolean[] v2;
    private static boolean[] v3;
    private static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            v1 = new boolean[n];
            v2 = new boolean[n * 2];
            v3 = new boolean[n * 2];

            res = 0;
            bt(0);
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static void bt(int cnt) {
        if (cnt == n) {
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!v1[i] && !v2[cnt + i] && !v3[i - cnt + n - 1]) {
                v1[i] = v2[cnt + i] = v3[i - cnt + n - 1] = true;
                bt(cnt + 1);
                v1[i] = v2[cnt + i] = v3[i - cnt + n - 1] = false;
            }
        }
    }
}