package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, m, count int
	fmt.Fscan(rw, &n, &m)

	s := make([]int, n+1)
	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &s[i])
	}
	start := 0
	end := 1
	sum := s[0]
	for {
		if start == len(s) && end == len(s) {
			break
		}

		if sum < m && end != len(s) {
			sum += s[end]
			end++
		} else {
			if sum == m {
				count++
			}
			sum -= s[start]
			start++
		}
	}
	fmt.Println(count)
}
