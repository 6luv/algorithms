import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arrA = new int[n];
            int[] arrB = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            int nIdx = 0;
            int mIdx = 0;
            while (true) {
                if (mIdx >= m || nIdx >= n) break;
                if (arrA[nIdx] == arrB[mIdx]) {
                    nIdx++;
                    mIdx++;
                } else {
                    nIdx++;
                }
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append((mIdx == m ? "YES" : "NO"))
                    .append("\n");
        }

        System.out.println(sb);
    }
}