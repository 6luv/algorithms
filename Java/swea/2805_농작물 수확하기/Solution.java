import java.io.*;
import java.util.*;

class Solution {
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][];

            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().chars().map(c -> c - '0').toArray();
            }

            int res = cal();
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static int cal() {
        int sum = Arrays.stream(arr[n / 2]).sum();

        for (int i = 0; i < n / 2; i++) {
            for (int j = n / 2 - i; j <= n / 2 + i; j++) {
                sum += arr[i][j] + arr[n - i - 1][j];
            }
        }

        return sum;
    }
}