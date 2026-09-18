import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (char num : String.valueOf(i).toCharArray()) {
                if (num == '3' || num == '6' || num == '9') {
                    cnt++;
                }
            }

            if (cnt > 0) {
                for (int j = 0; j < cnt; j ++) {
                    sb.append("-");
                }
            } else {
                sb.append(String.valueOf(i));
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}