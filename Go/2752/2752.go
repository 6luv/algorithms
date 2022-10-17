package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	arr := make([]int, 3)
	r := bufio.NewReader(os.Stdin)
	for i := 0; i < 3; i++ {
		fmt.Fscan(r, &arr[i])
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i] < arr[j]
	})

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	for j := 0; j < 3; j++ {
		fmt.Fprintf(w, "%d ", arr[j])
	}
}
