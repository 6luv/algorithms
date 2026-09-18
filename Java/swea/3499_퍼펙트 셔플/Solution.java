import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc ++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            String[] cards = new String[n];
            for (int i = 0; i < n; i ++) {
                cards[i] = st.nextToken();
            }

            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < n / 2; i ++) {
                sb.append(cards[i]).append(" ");
                sb.append(cards[i + (n + 1) / 2]).append(" ");
            }

            if (n % 2 == 1) {
                sb.append(cards[n / 2]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
