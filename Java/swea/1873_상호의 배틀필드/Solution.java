import java.io.*;
import java.util.*;

class Solution {
    static String[] directions = { "<", "^", ">", "v" };
    static String[] commands = { "L", "U", "R", "D" };
    static int[][] dydx = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    static int startY;
    static int startX;
    static int startDir;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            String[][] map = new String[h][w];
            for (int i = 0; i < h; i++) {
                String[] inputs = br.readLine().split("");

                for (int j = 0; j < w; j++) {
                    map[i][j] = inputs[j];

                    int dir = Arrays.asList(directions).indexOf(map[i][j]);
                    if (dir != -1) {
                        startY = i;
                        startX = j;
                        startDir = dir;
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());
            String[] cmds = br.readLine().split("");

            for (String cmd : cmds) {
                int dir = Arrays.asList(commands).indexOf(cmd);
                if (dir == -1 && cmd.equals("S")) {
                    shoot(map, h, w);
                } else {
                    startDir = dir;
                    map[startY][startX] = directions[startDir];

                    int ny = startY + dydx[startDir][0];
                    int nx = startX + dydx[startDir][1];

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w)
                        continue;
                    if (!map[ny][nx].equals("."))
                        continue;

                    map[startY][startX] = ".";
                    map[ny][nx] = directions[startDir];

                    startY = ny;
                    startX = nx;
                }
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void shoot(String[][] map, int h, int w) {
        int x = startX;
        int y = startY;

        while (true) {
            int ny = y + dydx[startDir][0];
            int nx = x + dydx[startDir][1];

            if (ny < 0 || ny >= h || nx < 0 || nx >= w)
                break;

            if (map[ny][nx].equals("#"))
                break;

            if (map[ny][nx].equals("*")) {
                map[ny][nx] = ".";
                break;
            }

            x = nx;
            y = ny;
        }
    }
}