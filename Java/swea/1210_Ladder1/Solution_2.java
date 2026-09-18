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

            int x = 0;
            for (int i = 0; i < SIZE; i++) {
                if (ladder[SIZE - 1][i] == 2) {
                    x = i;
                    break;
                }
            }

            for (int i = SIZE - 1; i >= 0; i --) {
                if (x > 0 && ladder[i][x-1] == 1) {
                    while (x > 0 && ladder[i][x-1] == 1) {
                        x --;
                    }
                } else if (x < SIZE - 1 && ladder[i][x+1] == 1) {
                    while (x < SIZE - 1 && ladder[i][x+1] == 1) {
                        x ++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(x).append("\n");
        }

        System.out.print(sb);
    }
}