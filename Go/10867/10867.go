package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func remove(arr []int, n int) []int {
	return append(arr[:n], arr[n+1:]...)
}

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

	for j := 0; j < len(arr)-1; j++ {
		if arr[j] == arr[j+1] {
			arr = remove(arr, j)
			j--
		}
	}

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	for k := 0; k < len(arr); k++ {
		fmt.Fprintf(w, "%d ", arr[k])
	}
}
