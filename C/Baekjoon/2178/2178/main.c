#include <stdio.h>

int n, m;
int front = 0, rear = 0;
int map[101][101];
int queue[10001][2];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

int bfs (void) {
    int nx, ny;
    queue[rear][0] = 1;
    queue[rear][1] = 1;
    rear++;
    
    while(front < rear) {
        int y = queue[front][0];
        int x = queue[front][1];
        front++;
        
        for (int i = 0; i < 4; i ++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 1 || ny < 1 || nx > m || ny > n)
                continue;
            if (map[ny][nx] != 1)
                continue;
            map[ny][nx] = map[y][x] + 1;
            queue[rear][0] = ny;
            queue[rear][1] = nx;
            rear++;
            
        }
    }
    return map[n][m];
}

int main(int argc, const char * argv[]) {
    int res = 0;
    scanf("%d %d", &n, &m);
    for (int i = 1; i <= n; i ++) {
        for (int j = 1; j <= m; j ++) {
            scanf("%1d", &map[i][j]);
        }
    }
    res = bfs();
    printf("%d", res);
    
    return 0;
}
