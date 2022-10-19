package main

import (
	"bufio"
	"fmt"
	"os"
)

var dp []int

func dpf(num int) int {
	dp[1] = 1
	dp[2] = 2
	dp[3] = 4

	for i := 4; i < 12; i++ {
		dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
	}

	return dp[num]

}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var t, n int
	fmt.Fscan(rw, &t)
	dp = make([]int, 12)

	for i := 0; i < t; i++ {
		fmt.Fscan(rw, &n)
		dpf(n)
		fmt.Fprintln(rw, dp[n])
	}
}
