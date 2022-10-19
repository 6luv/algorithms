package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, i, j int
	fmt.Fscan(rw, &n)

	for i = 1; i <= n; i++ {
		for j = n - i; j < n; j++ {
			fmt.Fprint(rw, "*")
		}
		fmt.Fprint(rw, "\n")
	}
	for i = 1; i < n; i++ {
		for j = n - i; j > 0; j-- {
			fmt.Fprint(rw, "*")
		}
		fmt.Fprint(rw, "\n")
	}
}
