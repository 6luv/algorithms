import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class UserSolution {
    private static final int MAX_GATE = 200;
    private static final int INF = 1_000_000_000;

    private static final int[] DY = {-1, 1, 0, 0};
    private static final int[] DX = {0, 0, -1, 1};

    int[][] map;
    int n;
    int maxStamina;

    int[][] gateMap;
    int[][] gateDist;
    int[][] gateInfo;

    void init(int N, int mMaxStamina, int mMap[][]) {
        this.n = N;
        this.map = new int[n][n];
        this.gateMap = new int[n][n];
        this.gateDist = new int[MAX_GATE][MAX_GATE];
        this.gateInfo = new int[MAX_GATE][2];
        this.maxStamina = mMaxStamina;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = mMap[i][j];
            }
        }

        for (int i = 0; i < MAX_GATE; i ++) {
            Arrays.fill(gateDist[i], INF);
        }
        return;
    }

    void addGate(int mGateID, int mRow, int mCol) {
        gateMap[mRow][mCol] = mGateID;
        gateInfo[mGateID][0] = mRow;
        gateInfo[mGateID][1] = mCol;

        gateDist[mGateID][mGateID] = 0;
        connect(mGateID);
        return;
    }

    void removeGate(int mGateID) {
        gateMap[gateInfo[mGateID][0]][gateInfo[mGateID][1]] = 0;
        gateInfo[mGateID][0] = gateInfo[mGateID][1] = 0;

        for (int i = 0; i < MAX_GATE; i ++) {
            gateDist[mGateID][i] = INF;
            gateDist[i][mGateID] = INF;
        }
        return;
    }

    int getMinTime(int mStartGateID, int mEndGateID) {
        if (gateDist[mStartGateID][mStartGateID] == INF || gateDist[mEndGateID][mEndGateID] == INF) {
            return -1;
        }

        if (mStartGateID == mEndGateID) {
            return 0;
        }

        int[] minTime = new int[MAX_GATE];
        boolean[] visited = new boolean[MAX_GATE];

        Arrays.fill(minTime, INF);
        minTime[mStartGateID] = 0;

        for (int count = 0; count < MAX_GATE; count++) {
            int currentGate = -1;

            for (int gateID = 0; gateID < MAX_GATE; gateID++) {
                if (gateDist[gateID][gateID] == INF) continue;
                if (visited[gateID]) continue;

                if (currentGate == -1 || minTime[gateID] < minTime[currentGate]) {
                    currentGate = gateID;
                }
            }

            if (currentGate == -1 || minTime[currentGate] == INF) {
                break;
            }

            if (currentGate == mEndGateID) {
                return minTime[currentGate];
            }

            visited[currentGate] = true;

            for (int nextGate = 0; nextGate < MAX_GATE; nextGate++) {
                if (gateDist[nextGate][nextGate] == INF) continue;
                if (visited[nextGate]) continue;
                if (gateDist[currentGate][nextGate] == INF) continue;

                int newTime = minTime[currentGate] + gateDist[currentGate][nextGate];
                if (newTime < minTime[nextGate]) {
                    minTime[nextGate] = newTime;
                }
            }
        }
        return -1;
    }

    void connect(int mGateID) {
        int startY = gateInfo[mGateID][0];
        int startX = gateInfo[mGateID][1];

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { startY, startX });

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        dist[startY][startX] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            int currentDist = dist[y][x];
            int otherGateID = gateMap[y][x];

            if (otherGateID > 0 && otherGateID != mGateID) {
                gateDist[mGateID][otherGateID] = currentDist;
                gateDist[otherGateID][mGateID] = currentDist;
            }

            if (currentDist == maxStamina) continue;

            for (int i = 0; i < 4; i ++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (map[ny][nx] == 1) continue;
                if (dist[ny][nx] != -1) continue;

                dist[ny][nx] = currentDist + 1;
                queue.offer(new int[] {ny, nx});
            }
        }
    }
}