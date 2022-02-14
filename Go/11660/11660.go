package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, m, x1, x2, y1, y2 int
	fmt.Fscan(rw, &n, &m)
	arr := make([][]int, n+1)
	sum := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		arr[i] = make([]int, n+1)
		sum[i] = make([]int, n+1)
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= n; j++ {
			fmt.Fscan(rw, &arr[i][j])
			sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j]
		}
	}

	for i := 0; i < m; i++ {
		fmt.Fscan(rw, &x1, &y1, &x2, &y2)
		fmt.Fprintln(rw, sum[x2][y2]-sum[x2][y1-1]-sum[x1-1][y2]+sum[x1-1][y1-1])
	}
}
