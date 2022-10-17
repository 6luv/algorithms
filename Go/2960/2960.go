package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, k, count int
	fmt.Fscan(rw, &n, &k)

	arr := make([]int, n+1)

	for i := 2; i <= n; i++ {
		arr[i] = i
	}

	for i := 2; i <= n; i++ {
		for j := i; j <= n; j += i {
			if arr[j] == 0 {
				continue
			}
			
			arr[j] = 0
			count++

			if count == k {
				fmt.Println(j)
			}
		}
	}

}
