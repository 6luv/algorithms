package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, m, a, b int
	fmt.Fscan(rw, &n)
	arr := make([]int, n+1)
	sum := make([]int, n+1)
	for i := 1; i <= n; i++ {
		fmt.Fscan(rw, &arr[i])
		sum[i] = sum[i-1] + arr[i]
	}
	fmt.Fscan(rw, &m)
	for i := 0; i < m; i++ {
		fmt.Fscan(rw, &a, &b)
		fmt.Fprintln(rw, sum[b]-sum[a-1])
	}
}
