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

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
            int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };

            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sumPlus = arr[i][j];
                    int sumCross = arr[i][j];

                    for (int d = 0; d < 8; d++) {
                        int ny = i;
                        int nx = j;
                        for (int k = 1; k < m; k++) {
                            ny += dy[d];
                            nx += dx[d];

                            if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                                break;

                            if (d < 4) {
                                sumPlus += arr[ny][nx];
                            } else {
                                sumCross += arr[ny][nx];
                            }
                        }
                    }

                    max = Math.max(max, Math.max(sumPlus, sumCross));
                }
            }
            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(max)
                    .append("\n");
        }
        System.out.println(sb);
    }
}