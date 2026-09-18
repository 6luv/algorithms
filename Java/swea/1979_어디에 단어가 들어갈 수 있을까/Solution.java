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
            int k = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {

                int rowCnt = 0;
                int colCnt = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        rowCnt++;
                    } else {
                        if (rowCnt == k) {
                            res++;
                        }
                        rowCnt = 0;
                    }

                    if (arr[j][i] == 1) {
                        colCnt++;
                    } else {
                        if (colCnt == k) {
                            res++;
                        }
                        colCnt = 0;
                    }
                }

                if (rowCnt == k) {
                    res++;
                }

                if (colCnt == k) {
                    res++;
                }
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(res)
                    .append("\n");
        }

        System.out.println(sb);
    }
}