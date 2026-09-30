import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            String n = br.readLine();
            int len = n.length();

            int min = Integer.MAX_VALUE;
            for (int i = 1; i < len; i++) {
                int op1 = Integer.parseInt(n.substring(0, i));
                int op2 = Integer.parseInt(n.substring(i, len));

                min = Math.min(min, op1 + op2);
            }

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }
}