package main

import (
	"bufio"
	"fmt"
	"os"
)

var dp [1001]int

func d(num int) int {
	dp[1] = 1
	dp[2] = 2

	if dp[num] != 0 {
		return dp[num]
	}

	dp[num] = (d(num-1) + d(num-2)) % 10007
	return dp[num]
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n int
	fmt.Fscan(rw, &n)

	fmt.Fprintln(rw, d(n))

}
