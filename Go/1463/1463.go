package main

import (
	"bufio"
	"fmt"
	"os"
)

var dp []int

func d(n int) int {
	dp[1] = 0
	dp[2] = 1
	dp[3] = 1

	if n == 1 {
		return 0
	}
	if dp[n] != 0 {
		return dp[n]
	}

	dp[n] = d(n-1) + 1
	if n%3 == 0 {
		if d(n/3)+1 < dp[n] {
			dp[n] = d(n/3) + 1
		}
	}
	if n%2 == 0 {
		if d(n/2)+1 < dp[n] {
			dp[n] = d(n/2) + 1
		}
	}
	return dp[n]
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n int
	fmt.Fscan(rw, &n)
	dp = make([]int, 1000001)
	fmt.Fprintln(rw, d(n))
}
