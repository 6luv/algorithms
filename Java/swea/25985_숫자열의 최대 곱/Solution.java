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
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            if (n > m) {
                int temp = n;
                n = m;
                m = temp;

                int[] tempArr = arr1;
                arr1 = arr2;
                arr2 = tempArr;
            }

            int[] longArr = new int[m + (n - 1) * 2];
            int[] shortArr = new int[n];

            for (int i = 0; i < arr2.length; i++) {
                longArr[n - 1 + i] = arr2[i];
            }
            shortArr = arr1;

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < longArr.length - (n - 1); i++) {
                int sum = 0;
                for (int j = 0; j < shortArr.length; j++) {
                    sum += longArr[i + j] * shortArr[j];
                }
                max = Math.max(max, sum);
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(max)
                    .append("\n");
        }
        System.out.println(sb);
    }
}