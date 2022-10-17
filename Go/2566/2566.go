package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var num, max, chex, chey int
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			fmt.Fscan(rw, &num)
			if max < num {
				chex = j
				chey = i
				max = num
			}
		}
	}
	fmt.Fprintln(rw, max)
	fmt.Fprintln(rw, chey+1, chex+1)
}
