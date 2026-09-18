import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());

            BigInteger sum = a.add(b);
            sb.append("#")
                .append(tc)
                .append(" ")
                .append(sum)
                .append("\n");
        }

        System.out.print(sb);
    }
}