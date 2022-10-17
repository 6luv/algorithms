//
//  main.c
//  1012
//
//  Created by 장민주 on 2022/07/13.
//

#include <stdio.h>
int map[51][51];
int map_copy[51][51];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

void dfs(int y, int x) {
    int nx, ny;
    map_copy[y][x] = 0;
    for (int i = 0; i < 4; i ++) {
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
    int t, m, n, k, x, y;
    int count;
    scanf("%d", &t);
    for (int l = 0; l < t; l ++) {
        
        scanf("%d %d %d", &m, &n, &k);
        for (int i = 0; i < k; i ++) {
            scanf("%d %d", &x, &y);
            map[y][x] = 1;
        }
    
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                map_copy[i][j] = map[i][j];
            }
        }
        count = 0;
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (map_copy[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        printf("%d\n", count);
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                }
            }
        }
    }
    return 0;
}
