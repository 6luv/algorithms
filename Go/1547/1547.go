package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var m, res, x, y int
	fmt.Fscan(rw, &m)

	res = 1
	for i := 0; i < m; i++ {
		fmt.Fscan(rw, &x, &y)
		if res == x {
			res = y
		} else if res == y {
			res = x
		}
	}
	fmt.Println(res)
}
