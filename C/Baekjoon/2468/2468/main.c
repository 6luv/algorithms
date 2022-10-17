#include <stdio.h>

int map[102][102];
int map_copy[102][102];
int N;
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};


void dfs (int x, int y, int l) {
    int nx, ny;
    map_copy[x][y] = -1;
    for (int i = 0; i < 4; i ++) {
        nx = x + dx[i];
        ny = y + dy[i];
        if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {
            if (map_copy[nx][ny] > l) {
                dfs(nx, ny, l);
            }
        }
    }
}

int main() {
    int max_rain = 0;
    int result = 0;
    int count = 0;
    

    for (int i = 0; i < 102; i ++) {
        for (int j = 0; j < 102; j ++) {
            map[i][j] = -1;
        }
    }
    
    scanf("%d", &N);
    for (int i = 1; i <= N; i ++) {
        for (int j = 1; j <= N; j ++) {
            scanf("%d", &map[i][j]);
            if (max_rain < map[i][j])
                max_rain = map[i][j];
        }
    }
        
    for (int l = 0; l <= max_rain; l ++) {
        for (int i = 1; i <= N; i ++) {
            for (int j = 1; j <= N; j ++) {
                map_copy[i][j] = map[i][j];
                if (map_copy[i][j] <= l) {
                    map_copy[i][j] = -1;
                }
            }
        }
        count = 0;
        for (int i = 1; i <= N; i ++) {
            for (int j = 1; j <= N; j ++) {
                if (map_copy[i][j] > -1) {
                    dfs(i, j, l);
                    count++;
                }
            }
        }
        if (result < count)
            result = count;
    }
    printf("%d\n", result);

    return 0;
}
