import java.io.*;
import java.util.*;

class Solution {
    private static final int SIZE = 100;
    private static final int[] DY = { 0, 0, -1 };
    private static final int[] DX = { -1, 1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());

            int[][] ladder = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < SIZE; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int endX = 0;
            for (int i = 0; i < SIZE; i++) {
                if (ladder[SIZE - 1][i] == 2) {
                    endX = i;
                    break;
                }
            }

            int x = dfs(ladder, SIZE - 1, endX);
            sb.append("#").append(tc).append(" ").append(x).append("\n");
        }

        System.out.print(sb);
    }

    private static int dfs(int[][] ladder, int y, int x) {
        if (y == 0) {
            return x;
        }

        for (int d = 0; d < 3; d++) {
            int ny = y + DY[d];
            int nx = x + DX[d];

            if (0 <= ny && ny < SIZE && 0 <= nx && nx < SIZE) {
                if (ladder[ny][nx] != 0) {
                    ladder[ny][nx] = 0;
                    return dfs(ladder, ny, nx);
                }
            }
        }

        return 0;
    }
}