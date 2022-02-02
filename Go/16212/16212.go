package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	var n int

	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &n)
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr[i])
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i] < arr[j]
	})

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	for j := 0; j < n; j++ {
		fmt.Fprintf(w, "%d ", arr[j])
	}
}
