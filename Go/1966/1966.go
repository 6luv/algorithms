package main

import (
	"bufio"
	"fmt"
	"os"
)

type Queue struct {
	index int
	value int
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var t, n, m, count int
	fmt.Fscan(rw, &t)

	for i := 0; i < t; i++ {
		fmt.Fscan(rw, &n, &m)
		queue := make([]Queue, n)
		for j := 0; j < n; j++ {
			fmt.Fscan(rw, &queue[j].value)
			queue[j].index = j
		}

		count = 0
		for len(queue) > 0 {
			index := 0
			for k := 1; k < len(queue); k++ {
				if queue[0].value < queue[k].value {
					index = k
					break
				}
			}
			if index > 0 {
				queue = append(queue[1:], queue[0])
			} else {
				count += 1
				if queue[0].index == m {
					fmt.Fprintln(rw, count)
				}
				queue = queue[1:]
			}

		}
	}

}
