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

	var n int
	var num big.Int
	res := new(big.Int)

	for j := 0; j < 3; j++ {
		fmt.Fscan(rw, &n)
		for i := 0; i < n; i++ {
			fmt.Fscan(rw, &num)
			res.Add(res, &num)
		}

		res.Sign()
		sign := res.Sign()
		if sign == 0 {
			fmt.Println("0")
		} else if sign == 1 {
			fmt.Println("+")
		} else {
			fmt.Println("-")
		}
		res.Sub(res, res)
	}
}
