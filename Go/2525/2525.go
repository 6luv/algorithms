package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var a, b, c int
	fmt.Fscan(rw, &a, &b)
	fmt.Fscan(rw, &c)

	b += c
	if b >= 60 {
		a += b / 60
		b -= (b / 60) * 60
	}
	if a >= 24 {
		a = a % 24
	}

	fmt.Fprint(rw, a, b)
}
