import java.io.*;
import java.util.*;

class Solution {
    private static final int MAX = 1_000_000;
    private static final int MOD = 1234567891;
    private static final long[] factorial = new long[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        factorial[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            long denom = factorial[r] * factorial[n - r] % MOD;
            long in = pow(denom, MOD - 2);
            long res = factorial[n] * in % MOD;

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static long pow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp /= 2;
        }

        return result;
    }
}