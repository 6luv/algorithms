import java.io.*;
import java.util.*;

class Solution {
    private static int[][] map;
    private static int n, x, res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0;
            for (int i = 0; i < n; i++) {
                if (check(map[i], new boolean[n]))
                    res++;

                int[] temp = new int[n];
                for (int j = 0; j < n; j++) {
                    temp[j] = map[j][i];
                }

                if (check(temp, new boolean[n]))
                    res++;
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean check(int[] road, boolean[] visited) {
        for (int i = 0; i < n - 1; i++) {
            if (road[i] < road[i + 1]) { // 오르막길
                if (road[i + 1] - road[i] != 1)
                    return false;

                for (int k = i; k > i - x; k--) {
                    if (k < 0 || road[k] != road[i] || visited[k])
                        return false;

                    visited[k] = true;
                }
            } else if (road[i] > road[i + 1]) { // 내리막길
                if (road[i] - road[i + 1] != 1)
                    return false;

                for (int k = i + 1; k < i + x + 1; k++) {
                    if (k >= n || road[k] != road[i + 1] || visited[k])
                        return false;

                    visited[k] = true;
                }
            }
        }
        return true;
    }
}