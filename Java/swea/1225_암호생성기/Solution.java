import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 10; tc++) {
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < 8; i ++) {
                queue.addLast(Integer.parseInt(st.nextToken()));
            }

            int decrease = 1;
            while (queue.peekLast() != 0) {
                int num = queue.pollFirst();
                queue.addLast(Math.max(num - decrease, 0));
                decrease = decrease % 5 + 1;
            }

            sb.append("#")
                .append(t)
                .append(" ");

            for (int item: queue) {
                sb.append(item).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
