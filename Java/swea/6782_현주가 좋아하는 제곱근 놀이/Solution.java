import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            long n = Long.parseLong(br.readLine());
            long min = 0;

            while (n != 2) {
                if (Math.sqrt(n) % 1 == 0) {
                    n = (long) Math.sqrt(n);
                    min++;
                } else {
                    n = (long) Math.pow(Math.ceil(Math.sqrt(n)), 2);
                    min += (long) Math.pow(Math.ceil(Math.sqrt(n)), 2) - n;
                }
            }

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }
}