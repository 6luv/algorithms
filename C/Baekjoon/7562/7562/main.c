#include <stdio.h>
#include <string.h>

int cx, cy, fx, fy, l;
int map[301][301];
int queue[900001][2];
int front, rear;
int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};

void init(void) {
    front = 0;
    rear = 0;
    memset(map, 0, sizeof(map));
    memset(queue, 0, sizeof(queue));
    
}

int bfs(void) {
    int nx, ny, px, py;
    map[cy][cx] = 1;
    queue[rear][0] = cy;
    queue[rear][1] = cx;
    rear++;
    
    while (front < rear) {
        py = queue[front][0];
        px = queue[front][1];
        front++;
        
        if (py == fy && px == fx)
            break;
        
        for (int i = 0; i < 8; i ++) {
            nx = px + dx[i];
            ny = py + dy[i];
            if (nx < 0 || ny < 0 || nx >= l || ny >= l)
                continue;
            if (map[ny][nx] != 0)
                continue;
            map[ny][nx] = map[py][px] + 1;
            queue[rear][0] = ny;
            queue[rear][1] = nx;
            rear++;
        }
    }
    return map[py][px] - 1;
}

int main(int argc, const char * argv[]) {
    int t;
    scanf("%d", &t);
    for (int i = 0; i < t; i ++) {
        init();
        scanf("%d", &l);
        scanf("%d %d", &cx, &cy);
        scanf("%d %d", &fx, &fy);
        printf("%d\n", bfs());
    }
    return 0;
}
