import java.io.*;
import java.util.*;

class Solution {
    static class Desk {
        int customer, endTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] receptionTime = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                receptionTime[i] = Integer.parseInt(st.nextToken());
            }

            int[] repairTime = new int[m + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                repairTime[i] = Integer.parseInt(st.nextToken());
            }

            int[] arrival = new int[k + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                arrival[i] = Integer.parseInt(st.nextToken());
            }

            Desk[] reception = new Desk[n + 1];
            for (int i = 1; i <= n; i++) {
                reception[i] = new Desk();
            }

            Desk[] repair = new Desk[m + 1];
            for (int i = 1; i <= m; i++) {
                repair[i] = new Desk();
            }

            int[] usedReception = new int[k + 1];
            int[] usedRepair = new int[k + 1];

            int time = 0;
            int finished = 0;

            PriorityQueue<Integer> receptionWait = new PriorityQueue<>();
            Deque<Integer> repairWait = new ArrayDeque<>();

            // 도착 -> 접수 대기열
            for (int i = 1; i <= k; i++) {
                receptionWait.offer(i);
            }

            while (finished < k) {
                // 정비 창구 -> 집
                for (int i = 1; i <= m; i++) {
                    if (repair[i].customer != 0 && repair[i].endTime == time) {
                        repair[i].customer = 0;
                        finished++;
                    }
                }

                // 접수 창구 -> 정비 대기열
                for (int i = 1; i <= n; i++) {
                    if (reception[i].customer != 0 && reception[i].endTime == time) {
                        repairWait.offer(reception[i].customer);
                        reception[i].customer = 0;
                    }
                }

                // 정비 대기열 -> 정비 창구
                for (int i = 1; i <= m; i++) {
                    if (repair[i].customer == 0 && !repairWait.isEmpty()) {
                        int cusIdx = repairWait.poll();

                        repair[i].customer = cusIdx;
                        repair[i].endTime = time + repairTime[i];
                        usedRepair[cusIdx] = i;
                    }
                }

                // 접수 대기열 -> 접수 창구
                for (int i = 1; i <= n; i++) {
                    if (reception[i].customer == 0 && !receptionWait.isEmpty()) {
                        if (arrival[receptionWait.peek()] <= time) {
                            int cusIdx = receptionWait.poll();

                            reception[i].customer = cusIdx;
                            reception[i].endTime = time + receptionTime[i];
                            usedReception[cusIdx] = i;
                        }
                    }
                }

                time++;
            }

            int sum = 0;
            for (int i = 1; i <= k; i++) {
                if (usedReception[i] == a && usedRepair[i] == b) {
                    sum += i;
                }
            }

            sb.append("#").append(tc).append(" ").append(sum != 0 ? sum : -1).append("\n");
        }

        System.out.print(sb);
    }

}