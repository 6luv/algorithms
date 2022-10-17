package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var out, in, sum, max int
	for i := 0; i < 10; i++ {
		fmt.Fscan(rw, &out, &in)
		sum -= out
		sum += in
		if max < sum {
			max = sum
		}
	}
	fmt.Fprint(rw, max)
}
