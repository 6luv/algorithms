package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	var n, k int
	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &n, &k)
	arr := make([]int, n)

	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr[i])
	}

	sort.Slice(arr, func(i, j int) bool {
		if arr[i] > arr[j] {
			return arr[i] < arr[j]
		}
		return arr[i] < arr[j]
	})

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	fmt.Fprintln(w, arr[k-1])
}
