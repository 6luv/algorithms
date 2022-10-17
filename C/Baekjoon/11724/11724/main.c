#include <stdio.h>

int map[1001][1001];
int visited[1001] = {0,};

void dfs(int x, int n) {
    visited[x] = 1;
    for (int i = 1; i <= n; i ++) {
        if (visited[i] == 0 && map[x][i] == 1) {
            dfs(i, n);
        }
    }
}

int main(int argc, const char * argv[]) {
    int n, m, u, v;
    int cnt = 0;
    
    scanf("%d %d", &n, &m);
    
    for (int i = 0; i < m; i ++) {
        scanf("%d %d", &u, &v);
        map[u][v] = 1;
        map[v][u] = 1;
    }
    
    for (int i = 1; i <= n; i ++) {
        if (visited[i] == 0) {
            dfs(i, n);
            cnt++;
        }
    }
    printf("%d", cnt);
    
    return 0;
}
