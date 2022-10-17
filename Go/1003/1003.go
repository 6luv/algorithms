package main

import (
	"bufio"
	"fmt"
	"os"
)

var dp0 []int
var dp1 []int

func fibonacci() {

	dp0[0] = 1
	dp1[1] = 1

	for i := 2; i < 41; i++ {
		dp0[i] = dp0[i-1] + dp0[i-2]
		dp1[i] = dp1[i-1] + dp1[i-2]
	}
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var t, n int
	fmt.Fscan(rw, &t)
	dp0 = make([]int, 41)
	dp1 = make([]int, 41)
	fibonacci()
	for i := 0; i < t; i++ {
		fmt.Fscan(rw, &n)
		fmt.Fprintf(rw, "%d %d\n", dp0[n], dp1[n])

	}
}
