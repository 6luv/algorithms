import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] operators = {"+", "-", "*", "/"};

        for (int tc = 1; tc <= 10; tc ++) {
            sb.append("#").append(tc).append(" ");
            int n = Integer.parseInt(br.readLine());
            boolean check = true;

            for (int i = 0; i < n; i ++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                String op = st.nextToken();

                if (st.countTokens() != 2 && Arrays.asList(operators).contains(op)) {
                    check = false;
                }

                if (st.countTokens() == 2 && !Arrays.asList(operators).contains(op)) {
                    check = false;
                }
            }

            sb.append(check ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}
