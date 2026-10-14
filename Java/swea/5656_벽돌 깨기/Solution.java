import java.io.*;
import java.util.*;

class Solution {
    private static final int[] DY = { -1, 1, 0, 0 };
    private static final int[] DX = { 0, 0, -1, 1 };

    private static int n, w, h, res;
    private static int[][] map;
    private static int[] selectNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = Integer.MAX_VALUE;
            selectNum = new int[n];
            select(0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }

    private static void select(int cnt) {
        if (cnt == n) {
            int[][] copiedMap = new int[map.length][];
            for (int i = 0; i < map.length; i++) {
                copiedMap[i] = map[i].clone();
            }

            for (int i = 0; i < n; i++) {
                boom(selectNum[i], copiedMap);
                drop(copiedMap);
            }
            countBlocks(copiedMap);
            return;
        }

        for (int i = 0; i < w; i++) {
            selectNum[cnt] = i;
            select(cnt + 1);
        }
    }

    private static void boom(int row, int[][] copiedMap) {
        int startH = -1;

        for (int i = 0; i < h; i++) {
            if (copiedMap[i][row] >= 1) {
                startH = i;
                break;
            }
        }

        if (startH == -1)
            return;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { startH, row, copiedMap[startH][row] });
        copiedMap[startH][row] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int range = current[2];

            for (int d = 0; d < 4; d++) {
                int ny = y;
                int nx = x;

                for (int r = 0; r < range - 1; r++) {
                    ny += DY[d];
                    nx += DX[d];

                    if (!isInRange(ny, nx))
                        continue;

                    if (copiedMap[ny][nx] > 1) {
                        queue.offer(new int[] { ny, nx, copiedMap[ny][nx] });
                    }
                    copiedMap[ny][nx] = 0;
                }
            }
        }
    }

    private static void drop(int[][] copiedMap) {
        for (int j = 0; j < w; j++) {
            int idx = h - 1;
            for (int i = h - 1; i >= 0; i--) {
                if (copiedMap[i][j] != 0) {
                    if (idx != i) {
                        copiedMap[idx][j] = copiedMap[i][j];
                        copiedMap[i][j] = 0;
                    }
                    idx--;
                }
            }
        }
    }

    private static void countBlocks(int[][] copiedMap) {
        int sum = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (copiedMap[i][j] > 0) {
                    sum++;
                }
            }
        }

        res = Math.min(res, sum);
    }

    private static boolean isInRange(int y, int x) {
        return 0 <= y && y < h && 0 <= x && x < w;
    }
}