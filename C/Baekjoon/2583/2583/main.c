#include <stdio.h>
#include <stdlib.h>

int m, n, cnt = 0;
int map[101][101];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

int dfs(int y, int x) {
    int nx, ny;
    map[y][x] = 0;
    for (int i = 0; i < 4; i ++) {
        nx = x + dx[i];
        ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
            if (map[ny][nx] == 1) {
                cnt++;
                dfs(ny, nx);
            }
        }
    }
    return cnt;
}

int main(int argc, const char * argv[]) {
    int k, ly, lx, ry, rx, tmp, count = 0;
    int res[101];
    scanf("%d %d %d", &m, &n, &k);
    for (int i = 0; i < m; i ++) {
        for (int j = 0; j < n; j ++) {
            map[i][j] = 1;
        }
    }
    for (int i = 0; i < k; i ++) {
        scanf("%d %d %d %d", &lx, &ly, &rx, &ry);
        
        for (int l = ly; l < ry; l ++) {
            for (int r = lx; r < rx; r ++) {
                map[l][r] = 0;
            }
        }
    }
    
    for (int i = 0; i < m; i ++) {
        for (int j = 0; j < n; j ++) {
            if (map[i][j] == 1) {
                cnt = 0;
                res[count] = dfs(i, j) + 1;
                count++;
            }
        }
    }
    
    printf("%d\n", count);
    
    for (int i = 0; i < count; i ++) {
        for (int j = i+1; j < count; j ++) {
            if (res[i] > res[j]) {
                tmp = res[i];
                res[i] = res[j];
                res[j] = tmp;
            }
        }
    }
    for (int i = 0; i < count; i ++) {
        printf("%d ", res[i]);
    }
    return 0;
}
