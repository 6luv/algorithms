package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	rw      = bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	graph   [][]int
	visited []bool
	cnt     int
)

func dfs(v int) {
	visited[v] = true
	cnt++
	for i := 0; i < len(graph); i++ {
		if graph[v][i] == 1 && !visited[i] {
			dfs(i)
		}
	}
}

func main() {
	defer rw.Flush()

	var n, m, v1, v2 int
	fmt.Fscan(rw, &n, &m)
	graph = make([][]int, n+1)
	for i := range graph {
		graph[i] = make([]int, n+1)
	}
	visited = make([]bool, n+1)
	for i := 0; i < m; i++ {
		fmt.Fscan(rw, &v1, &v2)
		graph[v1][v2] = 1
		graph[v2][v1] = 1
	}
	dfs(1)
	fmt.Fprintln(rw, cnt-1)
}
