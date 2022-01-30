package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	var n int
	fmt.Scanf("%d", &n)
	r := bufio.NewReader(os.Stdin)
	arr := make([][2]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr[i][0], &arr[i][1])
	}

	sort.Slice(arr, func(i, j int) bool {
		if arr[i][0] == arr[j][0] {
			return arr[i][1] < arr[j][1]
		}
		return arr[i][0] < arr[j][0]
	})

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	for i := 0; i < n; i++ {
		fmt.Fprintln(w, arr[i][0], arr[i][1])
	}
}
