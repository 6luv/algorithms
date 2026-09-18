import java.io.*;
import java.util.*;

class Solution {
    private static final int LIMIT = 2000;
    private static final int OFFSET = 2000;
    private static final int MAP_SIZE = 4001;
    private static final int[][] DYDX = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    private static int[][] map = new int[MAP_SIZE][MAP_SIZE];
    private static List<Atom> atoms;
    private static int res;

    static class Atom {
        int x, y, d, k;

        Atom(int x, int y, int d, int k) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.k = k;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            atoms = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) * 2;
                int y = Integer.parseInt(st.nextToken()) * 2;
                int d = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                atoms.add(new Atom(x, y, d, k));
            }

            res = 0;
            move();

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static void move() {
        while (atoms.size() >= 2) {
            List<Atom> nextAtoms = new ArrayList<>();

            for (Atom atom : atoms) {
                atom.y += DYDX[atom.d][0];
                atom.x += DYDX[atom.d][1];

                if (!isInRange(atom.y, atom.x))
                    continue;
                map[atom.y + OFFSET][atom.x + OFFSET]++;
            }

            for (Atom atom : atoms) {
                if (!isInRange(atom.y, atom.x))
                    continue;

                if (map[atom.y + OFFSET][atom.x + OFFSET] >= 2) {
                    res += atom.k;
                } else {
                    nextAtoms.add(atom);
                }
            }

            for (Atom atom : atoms) {
                if (!isInRange(atom.y, atom.x))
                    continue;

                map[atom.y + OFFSET][atom.x + OFFSET] = 0;
            }

            atoms = nextAtoms;
        }
    }

    private static boolean isInRange(int y, int x) {
        return -LIMIT <= y && y <= LIMIT && -LIMIT <= x && x <= LIMIT;
    }
}