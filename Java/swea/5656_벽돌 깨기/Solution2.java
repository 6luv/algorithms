import java.io.*;
import java.util.*;

class Solution2 {
    private static final int[] DY = { -1, 1, 0, 0 };
    private static final int[] DX = { 0, 0, -1, 1 };
    private static int n, w, h, res;

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

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int remaining = countBlocks(map);
            res = remaining;

            select(0, map, remaining);
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static void select(int cnt, int[][] map, int remaining) {
        if (res == 0) {
            return;
        }

        if (remaining == 0) {
            res = 0;
            return;
        }

        if (cnt == n) {
            res = Math.min(res, remaining);
            return;
        }

        for (int col = 0; col < w; col++) {
            int startY = -1;

            for (int y = 0; y < h; y++) {
                if (map[y][col] > 0) {
                    startY = y;
                    break;
                }
            }

            if (startY == -1) {
                continue;
            }

            int[][] copiedMap = copyMap(map);
            int destroyed = boom(startY, col, copiedMap);
            drop(copiedMap);
            select(cnt + 1, copiedMap, remaining - destroyed);

            if (res == 0) {
                return;
            }
        }
    }

    private static int boom(int startY, int col, int[][] map) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] { startY, col, map[startY][col] });
        map[startY][col] = 0;

        int destroyed = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int range = current[2];

            for (int d = 0; d < 4; d++) {
                for (int r = 1; r < range; r++) {
                    int ny = y + DY[d] * r;
                    int nx = x + DX[d] * r;

                    if (!isInRange(ny, nx)) {
                        break;
                    }

                    if (map[ny][nx] == 0) {
                        continue;
                    }

                    int power = map[ny][nx];

                    if (power > 1) {
                        queue.offer(new int[] { ny, nx, power });
                    }

                    map[ny][nx] = 0;
                    destroyed++;
                }
            }
        }

        return destroyed;
    }

    private static void drop(int[][] map) {
        for (int x = 0; x < w; x++) {
            int idx = h - 1;

            for (int y = h - 1; y >= 0; y--) {
                if (map[y][x] == 0) {
                    continue;
                }

                if (idx != y) {
                    map[idx][x] = map[y][x];
                    map[y][x] = 0;
                }

                idx--;
            }
        }
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copiedMap = new int[h][];

        for (int y = 0; y < h; y++) {
            copiedMap[y] = map[y].clone();
        }

        return copiedMap;
    }

    private static int countBlocks(int[][] map) {
        int count = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (map[y][x] > 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isInRange(int y, int x) {
        return 0 <= y && y < h && 0 <= x && x < w;
    }
}