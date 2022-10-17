//
//  main.c
//  2667
//
//  Created by 장민주 on 2022/07/13.
//

#include <stdio.h>
int map[25][25] = {-1,};
int map_copy[25][25];
int cnt = 0;
int com[626] = {0,};
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

int dfs(int x, int y) {
    int nx, ny;
    map_copy[x][y] = 0;
    for (int i = 0; i < 4; i ++) {
        nx = x + dx[i];
        ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < 25 && ny < 25) {
            if (map_copy[nx][ny] == 1) {
                cnt++;
                dfs(nx, ny);
            }
        }
    }
    return cnt;
}

int main(int argc, const char * argv[]) {
    int n, tmp, count = 0;
    
    
    scanf("%d", &n);
    for (int i = 0; i < n; i ++) {
        for (int j = 0; j < n; j ++) {
            scanf("%1d", &map[i][j]);
        }
    }
    
    for (int i = 0; i < n; i ++) {
        for (int j = 0; j < n; j ++) {
            map_copy[i][j] = map[i][j];
        }
    }
    
    for (int i = 0; i < n; i ++) {
        for (int j = 0; j < n; j ++) {
            if (map_copy[i][j] == 1) {
                cnt = 0;
                com[count] = dfs(i, j) + 1;
                count++;
            }
        }
    }
    printf("%d\n", count);
    for (int i = 0; i < count; i ++) {
        for (int j = 0; j < count-i-1; j ++) {
            if (com[j] > com[j+1]) {
                tmp = com[j];
                com[j] = com[j+1];
                com[j+1] = tmp;
            }
        }
    }
    for (int i = 0; i < count; i ++) {
        printf("%d\n", com[i]);
    }
    return 0;
}
