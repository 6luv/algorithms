package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	dp []int
)

func fibonacci(n int) int {
	if n == 0 {
		return 0
	}
	if n == 1 {
		return 1
	}
	if dp[n] != 0 {
		return dp[n]
	}
	dp[n] = fibonacci(n-1) + fibonacci(n-2)
	return dp[n]
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n int
	fmt.Fscan(rw, &n)
	dp = make([]int, n+1)
	fmt.Fprintln(rw, fibonacci(n))

}
