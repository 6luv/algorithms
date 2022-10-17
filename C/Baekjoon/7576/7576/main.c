#include <stdio.h>

int front, rear, n, m, res;
int map[1001][1001];
int queue[1000001][2];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

int bfs(void) {
    int nx, ny, popx, popy;
    
    while(front < rear) {
        popy = queue[front][0];
        popx = queue[front][1];
        front++;
        
        for (int i = 0; i < 4; i ++) {
            nx = popx + dx[i];
            ny = popy + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                continue;
            if (map[ny][nx] != 0)
                continue;
            
            queue[rear][0] = ny;
            queue[rear][1] = nx;
            map[ny][nx] = map[popy][popx] + 1;
            rear++;
            
        }
    }
    
    for (int i = 0; i < n; i ++) {
        for (int j = 0; j < m; j ++) {
            if (map[i][j] == 0) {
                return -1;
            }
        }
    }
    
    return map[popy][popx] - 1;
}

int main(int argc, const char * argv[]) {
    scanf("%d %d", &m, &n);
    
    for (int i = 0; i < n; i ++) {
        for (int j = 0; j < m; j ++) {
            scanf("%d", &map[i][j]);
        }
    }
    
    for (int i = 0; i < n; i ++) {
        for (int j = 0; j < m; j ++) {
            if (map[i][j] == 1) {
                queue[rear][0] = i;
                queue[rear][1] = j;
                rear++;
            }
        }
    }
    res = bfs();
    
    printf("%d", res);
    
    return 0;
}
