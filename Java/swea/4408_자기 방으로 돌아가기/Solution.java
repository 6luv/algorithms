import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[] rooms = new int[201];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                int min = Math.min(s, e);
                int max = Math.max(s, e);

                for (int j = (min + 1) / 2; j <= (max + 1) / 2; j++) {
                    rooms[j]++;
                }
            }

            int max = Arrays.stream(rooms).max().getAsInt();
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}