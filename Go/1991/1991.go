package main

import (
	"bufio"
	"fmt"
	"os"
)

//Algorithm DFS(G, v)
//	if v is already visited
//		return
//	Mark v as visited.
//	// Perform some operation on v.
//	for all neighbors x of v
//		DFS(G, x)

var ( //전역 변수
	rw      = bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	graph   [][]int
	visited []bool
)

func dfs(v int) { //dfs
	visited[v] = true                    //방문했으면 true
	fmt.Fprintf(rw, "%d ", v)            //정점 출력
	for i := 0; i < len(graph[v]); i++ { //graph 길이 만큼 반복
		if graph[v][i] == 1 && !visited[i] { //연결되어 있으면서 방문하지 않았을 때
			dfs(i) //dfs 호출
		}
	}
}

func bfs(v int) {
	visited[v] = true //방문했으면 true
	queue := []int{v}

	for len(queue) > 0 {
		f := queue[0]
		fmt.Fprintf(rw, "%d ", f)
		queue = queue[1:]
		for i := 0; i < len(graph); i++ {
			if graph[f][i] == 1 && !visited[i] {
				visited[i] = true
				queue = append(queue, i)
			}
		}
	}
}

func main() {
	defer rw.Flush()
	var n, m, v int
	var v1, v2 int

	fmt.Fscanln(rw, &n, &m, &v) //정점 개수 n, 간선 개수 m, 탐색을 시작할 정점 번호 v
	graph = make([][]int, n+1)
	visited = make([]bool, n+1)
	for i := range graph {
		graph[i] = make([]int, n+1)
	}

	for i := 0; i < m; i++ { // 간선 입력
		fmt.Fscanln(rw, &v1, &v2)
		graph[v1][v2] = 1 //연결되어 있다는 표시 1
		graph[v2][v1] = 1
	}
	dfs(v) //탐색을 시작할 정점 번호로 dfs 호출
	for i := 0; i < len(visited); i++ {
		visited[i] = false
	}
	fmt.Fprint(rw, "\n")
	bfs(v)
}
