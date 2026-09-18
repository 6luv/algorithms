import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc ++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i ++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int left = 0, right = n-1, max = -1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == m) {
                    max = m;
                    break;
                }

                if (sum <= m) {
                    max = Math.max(max, sum);
                    left++;
                } else if (sum > m) {
                    right--;
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}