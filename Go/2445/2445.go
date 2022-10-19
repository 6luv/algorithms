package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, i, j, k int
	fmt.Fscan(rw, &n)

	for i = 1; i <= 2*n/2; i++ {
		for j = 1; j <= i; j++ {
			fmt.Print("*")
		}
		for k = 2*n - 2*i; k > 0; k-- {
			fmt.Print(" ")
		}
		for j = 1; j <= i; j++ {
			fmt.Print("*")
		}
		fmt.Print("\n")
	}
	for i = 1; i <= 2*n/2-1; i++ {
		for j = n - i; j > 0; j-- {
			fmt.Print("*")
		}
		for k = 0; k < 2*i; k++ {
			fmt.Print(" ")
		}
		for j = n - i; j > 0; j-- {
			fmt.Print("*")
		}
		fmt.Print("\n")
	}
}
