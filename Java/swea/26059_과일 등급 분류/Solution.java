import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int lo = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] == arr[i]) {
                    continue;
                }

                for (int j = i + 1; j < n; j++) {
                    if (arr[j - 1] == arr[j]) {
                        continue;
                    }

                    int econ = i;
                    int stan = j - i;
                    int prem = n - j;

                    if (lo <= econ && econ <= hi && lo <= stan && stan <= hi && lo <= prem && prem <= hi) {
                        int maxValue = Math.max(prem, Math.max(stan, econ));
                        int minValue = Math.min(prem, Math.min(stan, econ));

                        min = Math.min(min, maxValue - minValue);
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                min = -1;
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(min)
                    .append("\n");
        }

        System.out.println(sb);
    }
}