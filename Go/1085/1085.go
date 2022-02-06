package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

func main() {
	var x, y, w, h, minX, minY int
	r := bufio.NewReader(os.Stdin)
	wr := bufio.NewWriter(os.Stdout)
	defer wr.Flush()

	fmt.Fscan(r, &x, &y, &w, &h)

	if w/2 < x {
		minX = w - x
	} else {
		minX = x
	}
	if h/2 < y {
		minY = h - y
	} else {
		minY = y
	}
	fmt.Fprintln(wr, math.Min(float64(minX), float64(minY)))

}
