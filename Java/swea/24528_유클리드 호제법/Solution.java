import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long p = y;
            while (p <= x) {
                p *= y;
            }

            long b = ((p + x - 1) / x) * x;
            long a = b * y + x;

            sb.append(a).append(' ').append(b).append('\n');
        }
        System.out.print(sb);
    }
}