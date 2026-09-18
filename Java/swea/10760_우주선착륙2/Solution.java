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

            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (check(i, j, n, m, arr)) {
                        cnt += 1;
                    }
                }
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(cnt)
                    .append("\n");
        }

        System.out.println(sb);
    }

    private static boolean check(int y, int x, int n, int m, int[][] arr) {
        int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                continue;
            if (arr[ny][nx] < arr[y][x]) {
                cnt++;
            }
        }
        return (cnt >= 4 ? true : false);
    }
}