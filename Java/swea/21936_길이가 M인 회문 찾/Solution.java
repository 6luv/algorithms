import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String input = br.readLine();

            boolean flag = true;
            sb.append("#" + tc + " ");

            for (int i = 0; i < n-m+1; i ++) {
                String word = input.substring(i, i+m);
                if (word.equals(new StringBuilder(word).reverse().toString())) {
                    sb.append(word).append("\n");
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }

            if (!flag) {
                sb.append("NONE").append("\n");
            }
        }

        System.out.println(sb);
    }
}