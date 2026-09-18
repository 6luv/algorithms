import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc ++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] prefix = new int[n+1][n+1];
            for (int i = 1; i <= n; i ++) {
                st = new StringTokenizer(br.readLine());
                
                for (int j = 1; j <= n; j ++) {
                    int value = Integer.parseInt(st.nextToken());
                    prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + value;
                }
            }

            int max = 0;
            for (int i = m; i <= n; i ++) {
                for (int j = m; j <= n; j ++) {
                    max = Math.max(max, prefix[i][j] - prefix[i-m][j] - prefix[i][j-m] + prefix[i-m][j-m]);
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}
