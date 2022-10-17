package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
)

var dp []big.Int

func fibonacci(num int) big.Int {

	sum := new(big.Int)
	if num == 0 {
		return 0
	}
	if num == 1 {
		return big.NewInt(int64(1))
	}

	if len(dp[num].Bits()) == 0 {
		return dp[num]
	}

	o := fibonacci(num - 1)
	w := fibonacci(num - 2)
	dp[num] = sum.Add(o, w)
	return dp[num]
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n int
	fmt.Fscan(rw, &n)
	dp = make([]big.Int, n)
	fibonacci(n)
	fmt.Fprintln(rw, dp)
}
