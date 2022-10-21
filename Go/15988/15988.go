package main

import (
	"bufio"
	"fmt"
	"os"
)

var dp []int

func d(n int) int {
	dp[1] = 1
	dp[2] = 2
	dp[3] = 4

	if dp[n] != 0 {
		return dp[n]
	}
	dp[n] = (d(n-1) + d(n-2) + d(n-3)) % 1000000009
	return dp[n]
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var t, n int
	fmt.Fscan(rw, &t)
	dp = make([]int, 1000001)
	for i := 0; i < t; i++ {
		fmt.Fscan(rw, &n)
		fmt.Fprintln(rw, d(n))
	}
}
