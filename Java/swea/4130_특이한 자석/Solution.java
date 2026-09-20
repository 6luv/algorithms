
import java.io.*;
import java.util.*;

class Solution {
    private static int[][] magnets;
    private static int[] rotation;
    private static int[] center;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int k = Integer.parseInt(br.readLine());
            magnets = new int[4][8];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            center = new int[4];
            for (int cmd = 0; cmd < k; cmd++) {
                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken()) - 1;
                int dir = Integer.parseInt(st.nextToken());

                rotation = new int[4];
                rotation[num] = dir;
                rotate(num);

                for (int i = 0; i < 4; i++) {
                    if (rotation[i] == 1) {
                        center[i] = (center[i] - 1 + 8) % 8;
                    } else if (rotation[i] == -1) {
                        center[i] = (center[i] + 1) % 8;
                    }
                }
            }

            int sum = 0;
            for (int i = 0; i < 4; i++) {
                if (magnets[i][center[i]] == 1) {
                    sum += 1 << i;
                }
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }

    private static void rotate(int num) {
        for (int i = num; i < 3; i++) {
            int right = (center[i] + 2) % 8;
            int left = (center[i + 1] + 6) % 8;

            if (magnets[i][right] == magnets[i + 1][left]) {
                break;
            }
            rotation[i + 1] = -rotation[i];
        }

        for (int i = num; i > 0; i--) {
            int left = (center[i] + 6) % 8;
            int right = (center[i - 1] + 2) % 8;

            if (magnets[i][left] == magnets[i - 1][right]) {
                break;
            }
            rotation[i - 1] = -rotation[i];
        }
    }
}
