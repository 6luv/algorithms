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

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int min = arr[i][j];
                    int curY = i;
                    int curX = j;
                    int cnt = 1;
                    while (true) {
                        int nextY = curY;
                        int nextX = curX;

                        for (int d = 0; d < 4; d++) {
                            int ny = curY + dy[d];
                            int nx = curX + dx[d];

                            if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                                continue;
                            if (arr[ny][nx] < min) {
                                min = arr[ny][nx];
                                nextY = ny;
                                nextX = nx;
                            }
                        }

                        if (nextY == curY && nextX == curX)
                            break;
                        
                        cnt++;
                        curY = nextY;
                        curX = nextX; 
                    }

                    max = Math.max(max, cnt);
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