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
		for k = 1; k < i; k++ {
			fmt.Print(" ")
		}
		for j = 2*n - 2*i + 1; j > 0; j-- {
			fmt.Print("*")
		}
		fmt.Print("\n")
	}
	for i = 1; i < 2*n/2; i++ {
		for k = n - i - 1; k > 0; k-- {
			fmt.Print(" ")
		}
		for j = 1; j <= 2*i+1; j++ {
			fmt.Print("*")
		}
		fmt.Print("\n")
	}
}
