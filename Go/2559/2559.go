package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, k, sum int
	fmt.Fscan(rw, &n, &k)
	arr := make([]int, n+1)
	for i := 1; i <= n; i++ {
		fmt.Fscan(rw, &arr[i])
	}
	for i := 1; i <= k; i++ {
		sum += arr[i]
	}
	max := sum
	for i := 1; i <= n-k; i++ {
		sum -= arr[i]
		sum += arr[i+k]
		if max < sum {
			max = sum
		}
	}
	fmt.Fprintln(rw, max)
}
