package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n1, n2 int
	for {
		fmt.Fscan(rw, &n1, &n2)
		if n1 == 0 && n2 == 0 {
			break
		}
		if n2%n1 == 0 {
			fmt.Println("factor")
		} else if n1%n2 == 0 {
			fmt.Println("multiple")
		} else {
			fmt.Println("neither")
		}
	}
}
