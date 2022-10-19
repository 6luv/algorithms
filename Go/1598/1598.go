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

	var x, y int
	fmt.Fscan(rw, &x, &y)
	x -= 1
	y -= 1

	dis := math.Abs(float64(y/4-x/4)) + math.Abs(float64(x%4-y%4))
	fmt.Println(int(dis))
}
