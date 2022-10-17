#include <stdio.h>

int m, n, h;
int map[101][101][101];
int queue[100*100*100+1][3];
int front = 0, rear = 0;
int dx[] = {0, 0, 1, -1, 0, 0};
int dy[] = {1, -1, 0, 0, 0, 0};
int dz[] = {0, 0, 0, 0, 1, -1};

int bfs(void) {
    int nx, ny, nz, px, py, pz;
    
    while(front < rear) {
        px = queue[front][2];
        py = queue[front][1];
        pz = queue[front][0];
        front++;
        
        for (int i = 0; i < 6; i ++) {
            nx = px + dx[i];
            ny = py + dy[i];
            nz = pz + dz[i];
            
            if (nx < 0 || ny < 0 || nz < 0 || nx >= m || ny >= n || nz >= h)
                continue;
            if (map[nz][ny][nx] != 0)
                continue;
            
            map[nz][ny][nx] = map[pz][py][px] + 1;
            queue[rear][0] = nz;
            queue[rear][1] = ny;
            queue[rear][2] = nx;
            rear++;
        }
    }
    
    for (int i = 0; i < h; i ++) {
        for (int j = 0; j < n; j ++) {
            for (int k = 0; k < m; k ++) {
                if (map[i][j][k] == 0)
                    return -1;
            }
        }
    }
    
    return map[pz][py][px] - 1;
}

int main(int argc, const char * argv[]) {
    
    scanf("%d %d %d", &m, &n, &h);
    for (int i = 0; i < h; i ++) {
        for (int j = 0; j < n; j ++) {
            for (int k = 0; k < m; k ++) {
                scanf("%d", &map[i][j][k]);
            }
        }
    }
    
    for (int i = 0; i < h; i ++) {
        for (int j = 0; j < n; j ++) {
            for (int k = 0; k < m; k ++) {
                if (map[i][j][k] == 1) {
                    queue[rear][0] = i;
                    queue[rear][1] = j;
                    queue[rear][2] = k;
                    rear++;
                }
            }
        }
    }
    
    int res = bfs();
    printf("%d", res);
    return 0;
}
