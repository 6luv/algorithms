package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var t, n int
	var num big.Int
	sum := new(big.Int)
	fmt.Fscan(rw, &t)

	for i := 0; i < t; i++ {
		fmt.Fscan(rw, &n)
		for j := 0; j < n; j++ {
			fmt.Fscan(rw, &num)
			sum.Add(sum, &num)
		}
		res := sum.Mod(sum, big.NewInt(int64(n)))

		if len(res.Bits()) == 0 {
			fmt.Fprintln(rw, "YES")
		} else {
			fmt.Fprintln(rw, "NO")
		}

		sum.Sub(sum, sum)

	}
}
