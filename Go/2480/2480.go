package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var a, b, c int
	var max float64
	fmt.Fscan(rw, &a, &b, &c)
	if a == b && b == c {
		fmt.Fprintln(rw, 10000+(a*1000))
	} else if (a == b && a != c) || (a == c && a != b) {
		fmt.Fprintln(rw, 1000+(a*100))
	} else if b == c && b != a {
		fmt.Fprintln(rw, 1000+(b*100))
	} else {
		max = math.Max(float64(a), float64(b))
		max = math.Max(max, float64(c))
		fmt.Fprintln(rw, max*100)
	}
}
