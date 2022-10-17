#include <stdio.h>

int n, k;
int front, rear;
int queue[1000001];
int graph[1000001];
int dx[] = {-1, 1, 2};

void bfs(void) {
    int nx, popx;
    
    queue[rear] = n;
    rear++;
    
    while (front < rear) {
        popx = queue[front];
        front++;
        for (int i = 0; i < 3; i ++) {
            if (i != 2) {
                nx = popx + dx[i];
            } else {
                nx = popx * dx[i];
            }
            
            if (nx < 0 || nx > 100000)
                continue;
            
            if (popx == k)
                break;
            
            if (graph[nx] == 0) {
                graph[nx] = graph[popx] + 1;
                queue[rear] = nx;
                rear++;
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    scanf("%d %d", &n, &k);
    bfs();
    printf("%d", graph[k]);
    return 0;
}
