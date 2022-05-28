package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, m int

	fmt.Fscan(rw, &n, &m)
	arr := make([]int, m+1)

	for i := 2; i <= m; i++ {
		arr[i] = i
	}

	for i := 2; i <= m; i++ {
		if arr[i] == 0 {
			continue
		}
		for j := i * 2; j <= m; j += i {
			arr[j] = 0
		}
	}

	for i := n; i <= m; i++ {
		if arr[i] != 0 {
			fmt.Println(arr[i])
		}
	}
}
