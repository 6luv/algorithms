package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, i, j, k, l, o int
	fmt.Fscan(rw, &n)
	for i = 1; i < n; i++ {
		for l = n - i - 1; l >= 0; l-- {
			fmt.Print(" ")
		}
		for o = 1; o <= 2*i-1; o++ {
			fmt.Print("*")
		}
		fmt.Printf("\n")
	}
	for i = n; i > 0; i-- {
		for j = 0; j < n-i; j++ {
			fmt.Print(" ")
		}
		for k = 2*i - 1; k > 0; k-- {
			fmt.Print("*")
		}
		fmt.Println()
	}
}
