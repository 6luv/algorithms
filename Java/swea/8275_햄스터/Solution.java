import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static int x;
    static int m;
    static int max;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            max = -1;
            answer = null;

            int[] hamsters = new int[n + 1];
            int[][] records = new int[m][3];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                records[i][0] = Integer.parseInt(st.nextToken());
                records[i][1] = Integer.parseInt(st.nextToken());
                records[i][2] = Integer.parseInt(st.nextToken());
            }

            dfs(hamsters, 1, records);
            sb.append("#").append(tc).append(" ");

            if (answer == null) {
                sb.append(-1);
            } else {
                for (int i = 1; i <= n; i++) {
                    sb.append(answer[i]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int[] hamsters, int cnt, int[][] records) {
        if (cnt == n + 1) {
            for (int i = 0; i < m; i++) {
                int sum = 0;

                for (int j = records[i][0]; j <= records[i][1]; j++) {
                    sum += hamsters[j];
                }

                if (sum != records[i][2]) {
                    return;
                }
            }

            int total = 0;

            for (int i = 1; i <= n; i++) {
                total += hamsters[i];
            }

            if (max < total) {
                max = total;
                answer = hamsters.clone();
            }

            return;
        }

        for (int i = 0; i <= x; i++) {
            hamsters[cnt] = i;
            dfs(hamsters, cnt + 1, records);
        }
    }
}