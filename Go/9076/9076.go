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

	var t int
	fmt.Fscan(rw, &t)
	arr := make([]int, 5)
	for i := 0; i < t; i++ {
		for j := 0; j < 5; j++ {
			fmt.Fscan(rw, &arr[j])
		}
		sort.Slice(arr, func(k, l int) bool {
			return arr[k] < arr[l]
		})

		if arr[3]-arr[1] >= 4 {
			fmt.Fprintln(rw, "KIN")
		} else {
			fmt.Fprintln(rw, arr[1]+arr[2]+arr[3])
		}
	}
}
