package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var p, q, cnt, res int
	fmt.Fscan(rw, &p, &q)

	for i := 1; i <= p; i++ {
		if p%i == 0 {
			cnt += 1
			if cnt == q {
				res = i
				break
			}
		}
		res = 0
	}
	fmt.Fprint(rw, res)
}
