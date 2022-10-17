#include <stdio.h>

char area[101][101];
char area_copy[101][101];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

void colorless_dfs(int y, int x, char c) {
    int nx, ny;
    area[y][x] = 'H';
    for (int i = 0; i < 4; i ++) {
        nx = x + dx[i];
        ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx <= 100 & ny <= 100) {
            if (area[ny][nx] == c) {
                colorless_dfs(ny, nx, c);
            }
        }
    }
}

void dfs(int y, int x, char c) {
    int nx, ny;
    area_copy[y][x] = 'H';
    for (int i = 0; i < 4; i ++) {
        nx = x + dx[i];
        ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx <= 100 & ny <= 100) {
            if (area_copy[ny][nx] == c) {
                dfs(ny, nx, c);
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    int n;
    int cnt = 0, c_cnt = 0;
    scanf("%d", &n);
    getchar();
    for (int i = 0; i < n; i ++) {
        for (int j = 0; j < n; j ++) {
            scanf("%c", &area[i][j]);
            area_copy[i][j] = area[i][j];
            if (area[i][j] == 'G') {
                area[i][j] = 'R';
            }
        }
        getchar();
    }
    
    for (int i = 0; i < n; i ++) {
        for (int j = 0; j < n; j ++) {
            if (area_copy[i][j] != 'H') {
                dfs(i, j, area_copy[i][j]);
                cnt++;
            }
            if (area[i][j] != 'H') {
                colorless_dfs(i, j, area[i][j]);
                c_cnt++;
            }
        }
    }
    printf("%d %d", cnt, c_cnt);
    
    return 0;
}
