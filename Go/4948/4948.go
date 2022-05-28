package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, count int
	arr := make([]int, 123456*2+1)
	for i := 2; i <= 123456*2; i++ {
		arr[i] = i
	}

	for i := 2; i <= 123456*2; i++ {
		if arr[i] == 0 {
			continue
		}
		for j := 2 * i; j <= 123456*2; j += i {
			arr[j] = 0
		}
	}

	for {
		fmt.Fscan(rw, &n)

		if n == 0 {
			break
		}
		for i := n + 1; i <= 2*n; i++ {
			if arr[i] != 0 {
				count++
			}
		}
		fmt.Println(count)
		count = 0
	}
}
