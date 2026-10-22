import java.io.*;
import java.util.*;

class Solution {
    private static Vector[] vectors;
    private static int n;

    static class Vector {
        long x, y, z;

        Vector(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        Vector getCross(Vector other) {
            return new Vector(
                    this.y * other.z - this.z * other.y,
                    this.z * other.x - this.x * other.z,
                    this.x * other.y - this.y * other.x);
        }

        long getDot(Vector other) {
            return this.x * other.x + this.y * other.y + this.z * other.z;
        }

        Vector getSub(Vector other) {
            return new Vector(other.x - this.x, other.y - this.y, other.z - this.z);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ", " + z + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            vectors = new Vector[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                vectors[i] = new Vector(x, y, z);
            }

            boolean res = check();
            sb.append("#").append(tc).append(" ").append(res ? "TAK" : "NIE").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean check() {
        if (n <= 3) {
            return true;
        }

        Vector a = vectors[0];
        Vector ab = a.getSub(vectors[1]);

        Vector normal = null;
        int start = n;

        for (int i = 2; i < n; i++) {
            Vector ac = a.getSub(vectors[i]);
            Vector cross = ab.getCross(ac);

            if (cross.x != 0 || cross.y != 0 || cross.z != 0) {
                normal = cross;
                start = i + 1;
                break;
            }
        }

        if (normal == null) {
            return true;
        }

        for (int i = start; i < n; i++) {
            Vector ap = a.getSub(vectors[i]);
            if (normal.getDot(ap) != 0) {
                return false;
            }
        }

        return true;
    }
}