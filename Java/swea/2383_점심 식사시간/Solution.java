import java.io.*;
import java.util.*;

class Solution {
    private static List<Position> stairs;
    private static List<Position> people;
    private static int[][] map;
    private static int[] selectedStairs;
    private static int res;

    static class Position {
        int y, x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());

            stairs = new ArrayList<>();
            people = new ArrayList<>();
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 1) {
                        people.add(new Position(i, j));
                    } else if (map[i][j] > 1) {
                        stairs.add(new Position(i, j));
                    }
                }
            }

            selectedStairs = new int[people.size()];
            res = Integer.MAX_VALUE;
            assign(0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static void assign(int depth) {
        if (depth == people.size()) {
            cal();
            return;
        }

        selectedStairs[depth] = 0;
        assign(depth + 1);

        selectedStairs[depth] = 1;
        assign(depth + 1);
    }

    private static void cal() {
        List<Integer>[] arrival = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            arrival[i] = new ArrayList<>();
        }

        for (int i = 0; i < people.size(); i++) {
            int stairIdx = selectedStairs[i];

            Position person = people.get(i);
            Position stair = stairs.get(stairIdx);

            int d = Math.abs(stair.y - person.y)
                    + Math.abs(stair.x - person.x);

            arrival[stairIdx].add(d);
        }

        Collections.sort(arrival[0]);
        Collections.sort(arrival[1]);

        int time1 = getTime(arrival[0], arrival[0].size(), 0);
        int time2 = getTime(arrival[1], arrival[1].size(), 1);

        res = Math.min(res, Math.max(time1, time2));
    }

    private static int getTime(List<Integer> arrival, int length, int stair) {
        int[] time = new int[length];
        int k = map[stairs.get(stair).y][stairs.get(stair).x];

        for (int i = 0; i < length; i++) {
            int arrive = arrival.get(i) + 1;

            if (i < 3) {
                time[i] = arrive + k;
            } else {
                time[i] = Math.max(arrive, time[i - 3]) + k;
            }
        }

        return length == 0 ? 0 : time[length - 1];
    }
}