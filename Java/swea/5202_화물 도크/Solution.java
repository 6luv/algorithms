import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[][] works = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                works[i][0] = s;
                works[i][1] = e;
            }

            Arrays.sort(works, (a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });

            int end = 0;
            int cnt = 0;
            for (int[] work : works) {
                if (work[0] >= end) {
                    cnt++;
                    end = work[1];
                }
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}