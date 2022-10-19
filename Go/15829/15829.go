package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
)

func ascii(num string) []int {
	index := make([]int, len(num))
	for i := 0; i < len(num); i++ {
		index[i] = int(num[i]) - 96
	}
	return index
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var l int
	var alpha string
	fmt.Fscan(rw, &l)
	fmt.Fscan(rw, &alpha)
	index := ascii(alpha)

	res := new(big.Int)
	sum := new(big.Int)
	mul := new(big.Int)
	mod := new(big.Int)

	for i := 0; i < len(alpha); i++ {
		var k, e = big.NewInt(31), big.NewInt(int64(i))
		k.Exp(k, e, nil)
		mod = mod.Mod(k, big.NewInt(1234567891))
		mul = mul.Mul(big.NewInt(int64(index[i])), mod)
		sum = sum.Add(sum, mul)
		res = sum.Mod(sum, big.NewInt(1234567891))
	}
	fmt.Fprintln(rw, res)
}
