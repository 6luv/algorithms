package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

// 규칙 : 2^n - x -> 2^n - 2*x
// 2^n - x = a
// 2^n = a + x
// n = log2(a+x)
// 3 -> 2  n -> 2
// 4 -> 2  n -> 2
// 5 -> 3  n -> 3

func main() {
	var a int
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscan(r, &a)
	n := math.Ceil(math.Log2(float64(a)))
	x := math.Pow(2, n) - float64(a)
	fmt.Fprintln(w, math.Pow(2, n)-2*x)
}
