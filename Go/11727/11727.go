package main

import (
	"bufio"
	"fmt"
	"os"
)

var d []int

func dp(n int) int {
	if n == 1 {
		return 1
	}
	if n == 2 {
		return 3
	}

	if d[n] != 0 {
		return d[n]
	}

	d[n] = (dp(n-1) + 2*dp(n-2)) % 10007
	return d[n]
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n int
	fmt.Fscan(rw, &n)
	d = make([]int, n+1)
	fmt.Fprintln(rw, dp(n))
}
