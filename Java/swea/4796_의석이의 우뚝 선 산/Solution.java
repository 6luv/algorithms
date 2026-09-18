import java.util.*;

class Solution {
    private static int n;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int cnt = cal();
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }

    private static int cal() {
        int cnt = 0;
        int up = 0;
        int down = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                if (down > 0) {
                    cnt += up * down;
                    up = 1;
                    down = 0;
                } else {
                    up++;
                }
            } else if (arr[i - 1] > arr[i]) {
                down++;
            }
        }

        cnt += up * down;
        return cnt;
    }
}