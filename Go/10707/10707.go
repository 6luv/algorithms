package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var xa, yb, yc, yd, jp, chax, chay int
	fmt.Fscan(rw, &xa, &yb, &yc, &yd, &jp)

	chax = xa * jp
	if yc >= jp {
		chay = yb
	} else {
		chay = yb + (jp-yc)*yd
	}

	if chax < chay {
		fmt.Fprintln(rw, chax)
	} else {
		fmt.Fprintln(rw, chay)
	}
}
