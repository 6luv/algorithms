import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int _ = Integer.parseInt(br.readLine());

            Deque<Character> queue = new ArrayDeque<>();
            char[] chars = br.readLine().toCharArray();

            boolean ok = true;
            for (char ch : chars) {
                if (ch == '(' || ch == '{' || ch == '[' || ch == '<') {
                    queue.offer(ch);
                } else {
                    if (queue.isEmpty()) {
                        ok = false;
                        break;
                    }

                    char op = queue.pollLast();
                    if (!(op == '(' && ch == ')' || op == '{' && ch == '}' || op == '[' && ch == ']'
                            || op == '<' && ch == '>')) {
                        ok = false;
                        break;
                    }
                }
            }

            if (!queue.isEmpty()) {
                ok = false;
            }

            sb.append("#").append(tc).append(" ").append(ok ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}
