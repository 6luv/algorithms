import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int total = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                total += arr[i];
            }

            int leftSum = 0;
            int minDiff = total;
            int idx = 0;
            
            for (int i = 0; i < n - 1; i++) {
                leftSum += arr[i];
                int rightSum = total - leftSum;
                int diff = Math.abs(leftSum - rightSum);

                if (minDiff > diff) {
                    minDiff = diff;
                    idx = i + 1;
                }
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(idx)
                    .append(" ")
                    .append(minDiff)
                    .append("\n");
        }

        System.out.println(sb);
    }
}