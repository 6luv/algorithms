package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var t, n int
	fmt.Fscan(rw, &t)

	for i := 0; i < t; i++ {
		sum := 0
		min := 100
		for j := 0; j < 7; j++ {
			fmt.Fscan(rw, &n)
			if n%2 == 0 {
				sum += n
				if min > n {
					min = n
				}
			}
		}
		fmt.Fprintln(rw, sum, min)
	}
}
