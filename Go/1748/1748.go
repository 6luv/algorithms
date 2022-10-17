package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, res int
	fmt.Fscan(rw, &n)

	if n < 10 {
		fmt.Println(rw, res)
	} else if n < 100 {
		res += 9
		
	}
}
