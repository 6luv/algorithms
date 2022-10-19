package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var m, n, sum, cnt int
	fmt.Fscan(rw, &m, &n)

	min := n + 1
	for i := m; i <= n; i++ {
		cnt = 0
		for j := 0; j < i; j++ {
			if i%(j+1) == 0 {
				cnt += 1
			}
		}
		if cnt == 2 {
			sum += i
			if min > i {
				min = i
			}
		}
	}
	if sum == 0 {
		fmt.Fprintln(rw, "-1")
	} else {
		fmt.Fprintln(rw, sum)
		fmt.Fprintln(rw, min)
	}
}
