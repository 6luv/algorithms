package main

import (
	"fmt"
	"math/big"
)

func main() {
	var a, b big.Int
	fmt.Scanf("%d %d", &a, &b)
	add := new(big.Int)
	add = add.Add(&a, &b)
	fmt.Println(add)
}
