import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc ++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            int cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i ++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i ++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i ++) {
                if (arr1[i] != arr2[i]) {
                    arr2 = xor(i, n, arr2);
                    cnt ++;
                }
            }

            sb.append("#" + tc + " " + cnt + "\n");
        }

        System.out.println(sb);
    }

    private static int[] xor(int start, int end, int[] arr) {
        for (int i = start; i < end; i ++) {
            arr[i] ^= 1;
        }
        return arr;
    }
}