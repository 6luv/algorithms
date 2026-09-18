import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int res = n * n - 1;

            int y = 0;
            int x = 0;

            sb.append("#" + tc + " ");
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        res--;
                    } else if (arr[i][j] == 2) {
                        y = i;
                        x = j;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = y;
                int nx = x;

                while (true) {
                    ny += dy[i];
                    nx += dx[i];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                        break;

                    if (arr[ny][nx] == 1)
                        break;
                    res--;
                }
            }

            sb.append(res + "\n");
        }

        System.out.println(sb);
    }
}