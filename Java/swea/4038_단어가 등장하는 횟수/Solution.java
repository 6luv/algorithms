
import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            String input = br.readLine();
            String pattern = br.readLine();

            int res = kmp(input, pattern);
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static int kmp(String input, String pattern) {
        int[] pi = makeTable(pattern);
        int count = 0, j = 0;

        for (int i = 0; i < input.length(); i++) {
            while (j > 0 && input.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (input.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    count++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        return count;
    }

    private static int[] makeTable(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}
