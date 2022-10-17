package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var a, b, v int
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	fmt.Fscan(rw, &a, &b, &v)
	if (v-a)%(a-b) == 0 {
		fmt.Fprintln(rw, ((v-a)/(a-b))+1)
	} else {
		fmt.Fprintln(rw, ((v-a)/(a-b))+2)
	}
}
