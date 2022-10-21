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

	var n, min, max, num int
	fmt.Fscan(rw, &n)

	if n == 1 {
		fmt.Fscan(rw, &num)
		fmt.Fprintln(rw, math.Pow(float64(num), 2))
	} else {
		for i := 0; i < n; i++ {
			fmt.Fscan(rw, &num)
			if i == 0 {
				min = num
			}
			if min > num {
				min = num
			}
			if max < num {
				max = num
			}
		}
		fmt.Fprintln(rw, min*max)
	}
}
