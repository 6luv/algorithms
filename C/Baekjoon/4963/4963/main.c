#include <stdio.h>

int map[51][51];
int map_copy[51][51];
int cnt;
int dx[] = {1, 1, -1, -1, 0, 0, 1, -1};
int dy[] = {1, -1, 1, -1, 1, -1, 0, 0};

void init(void) {
    cnt = 0;
    for (int i = 0; i < 51; i ++) {
        for (int j = 0; j < 51; j ++) {
            map[i][j] = 0;
            map_copy[i][j] = 0;
        }
    }
}

void dfs(int y, int x) {
    int nx, ny;
    map_copy[y][x] = 0;
    for (int i = 0; i < 8; i ++) {
        nx = x + dx[i];
        ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx <= 50 && ny <= 50) {
            if (map_copy[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }
    
}

int main(int argc, const char * argv[]) {
    int w, h, num;
    
    while (1) {
        scanf("%d %d", &w, &h);
        if (w == 0 && h == 0) {
            break;
        }
        
        init();
        for (int i = 0; i < h; i ++) {
            for (int j = 0; j < w; j ++) {
                scanf("%d", &num);
                map[i][j] = num;
                map_copy[i][j] = num;
            }
        }
        
        for (int i = 0; i < h; i ++) {
            for (int j = 0; j < w; j ++) {
                if (map_copy[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        printf("%d\n", cnt);
    }
    return 0;
}
