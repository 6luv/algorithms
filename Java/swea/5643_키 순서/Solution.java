
import java.io.*;
import java.util.*;

class Solution {

    private static int[][] adj;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            adj = new int[n + 1][n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a][b] = 1;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (adj[i][k] == 1 && adj[k][j] == 1) {
                            adj[i][j] = 1;
                        }
                    }
                }
            }

            int res = 0;
            for (int i = 1; i <= n; i++) {
                int cnt = 0;

                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (adj[i][j] == 1 || adj[j][i] == 1) {
                        cnt++;
                    }
                }

                if (cnt == n - 1) {
                    res++;
                }
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }
}
