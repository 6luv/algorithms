import java.io.*;
import java.util.*;

class Solution {
    private static final int[][] DYDX = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private static List<Core> cores;
    private static int n;
    private static int[][] map;
    private static int maxCore;
    private static int minLength;

    static class Core {
        int y, x;

        Core(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            initCores();
            maxCore = 0;
            minLength = Integer.MAX_VALUE;
            dfs(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(minLength).append("\n");
        }

        System.out.println(sb);
    }

    private static void initCores() {
        cores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
                    cores.add(new Core(i, j));
                }
            }
        }
    }

    private static void dfs(int idx, int coreCnt, int length) {
        if (coreCnt + (cores.size() - idx) < maxCore)
            return;

        if (idx == cores.size()) {
            if (coreCnt == maxCore) {
                minLength = Math.min(minLength, length);
            } else if (coreCnt > maxCore) {
                maxCore = coreCnt;
                minLength = length;
            }

            return;
        }

        Core core = cores.get(idx);
        int y = core.y;
        int x = core.x;

        for (int d = 0; d < 4; d++) {
            if (!canConnect(y, x, d)) {
                continue;
            }

            int len = updateWire(y, x, d, 2); // 전선 설치
            dfs(idx + 1, coreCnt + 1, length + len);
            updateWire(y, x, d, 0); // 전선 제거
        }

        dfs(idx + 1, coreCnt, length);
    }

    private static boolean canConnect(int y, int x, int d) {
        int ny = y + DYDX[d][0];
        int nx = x + DYDX[d][1];

        while (ny >= 0 && ny < n && nx >= 0 && nx < n) {
            if (map[ny][nx] != 0) {
                return false;
            }

            ny += DYDX[d][0];
            nx += DYDX[d][1];
        }

        return true;
    }

    private static int updateWire(int y, int x, int d, int value) {
        int ny = y + DYDX[d][0];
        int nx = x + DYDX[d][1];
        int len = 0;

        while (ny >= 0 && ny < n && nx >= 0 && nx < n) {
            map[ny][nx] = value;
            len++;

            ny += DYDX[d][0];
            nx += DYDX[d][1];
        }

        return len;
    }
}