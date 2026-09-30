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

            int[] weights = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            int[] trucks = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                trucks[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(weights);
            Arrays.sort(trucks);

            int idx = trucks.length - 1;
            int res = 0;
            for (int i = weights.length - 1; i >= 0; i--) {
                if (trucks[idx] >= weights[i]) {
                    res += weights[i];
                    idx--;
                } else {
                    continue;
                }

                if (idx < 0)
                    break;
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }
}