package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, m, k, x1, y1, x2, y2, sum int
	fmt.Fscan(rw, &n, &m)
	arr := make([][]int, n+1)
	for i := 1; i < n+1; i++ {
		arr[i] = make([]int, m+1)
	}
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			fmt.Fscan(rw, &arr[i][j])
		}
	}
	fmt.Fscan(rw, &k)
	for l := 0; l < k; l++ {
		fmt.Fscan(rw, &x1, &y1, &x2, &y2)
		for i := x1; i <= x2; i++ {
			for j := y1; j <= y2; j++ {
				sum += arr[i][j]
			}
		}
		fmt.Fprintln(rw, sum)
		sum = 0
	}
}
