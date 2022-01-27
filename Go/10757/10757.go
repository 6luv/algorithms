package main

import (
	"fmt"
	"math/big"
)

func main() {
	var a, b uint64
	newBigInt := big.NewInt(int64(10000))
	fmt.Scanf("%d %d", &a, &b)
	fmt.Println(a + b)
}
