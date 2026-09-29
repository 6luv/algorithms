import java.io.*;
import java.util.*;

class Solution {
    private static int[] group;
    private static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc ++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            group = new int[n + 1];
            for (int i = 1; i <= n; i ++) {
                group[i] = i;
            }

            cnt = n;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i ++) {
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                union(num1, num2);
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    private static void union(int num1, int num2) {
        int a = find(num1);
        int b = find(num2);

        if (a != b) {
            group[b] = a;
            cnt--;
        }
    }

    private static int find(int num) {
        if (group[num] == num) {
            return num;
        }

        return group[num] = find(group[num]);
    }
}