package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, max int
	fmt.Fscan(rw, &n)

	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &arr[i])
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i] < arr[j]
	})

	for i := 0; i < n; i++ {
		if max < arr[i]*(n-i) {
			max = arr[i] * (n - i)
		}
	}

	fmt.Fprintln(rw, max)

}
