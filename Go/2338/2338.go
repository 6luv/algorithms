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

	var a, b big.Int

	fmt.Fscan(rw, &a, &b)

	add := new(big.Int)
	add = add.Add(&a, &b)

	sub := new(big.Int)
	sub = sub.Sub(&a, &b)

	mul := new(big.Int)
	mul = mul.Mul(&a, &b)

	fmt.Println(add)
	fmt.Println(sub)
	fmt.Println(mul)
}
