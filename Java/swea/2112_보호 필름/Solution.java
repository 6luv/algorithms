import java.io.*;
import java.util.*;

class Solution {
    private static int d, w, k;
    private static int[][] film;
    private static int[] selected;
    private static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            film = new int[d][w];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = k;
            for (int target = 0; target <= k; target++) {
                selected = new int[target];
                found = false;

                choose(0, 0, target);

                if (found) {
                    answer = target;
                    break;
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    private static void choose(int start, int cnt, int target) {
        if (found)
            return;

        if (cnt == target) {
            apply(0);
            return;
        }

        for (int i = start; i <= d - (target - cnt); i++) {
            selected[cnt] = i;
            choose(i + 1, cnt + 1, target);

            if (found)
                return;
        }
    }

    private static void apply(int cnt) {
        if (found)
            return;

        if (cnt == selected.length) {
            found = check();
            return;
        }

        int row = selected[cnt];
        int[] original = film[row].clone();

        Arrays.fill(film[row], 0);
        apply(cnt + 1);

        if (!found) {
            Arrays.fill(film[row], 1);
            apply(cnt + 1);
        }

        film[row] = original;
    }

    private static boolean check() {
        if (k == 1)
            return true;

        for (int j = 0; j < w; j++) {
            int cnt = 1;
            boolean passed = false;

            for (int i = 1; i < d; i++) {
                if (film[i][j] == film[i - 1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                if (cnt >= k) {
                    passed = true;
                    break;
                }
            }

            if (!passed)
                return false;
        }

        return true;
    }
}