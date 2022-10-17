package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func binarySearch(arr []int, num int) int {
	low := 0
	high := len(arr) - 1
	for low <= high {
		mid := (low + high) / 2
		if arr[mid] == num {
			return 1
		} else if arr[mid] < num {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return 0
}

func main() {
	var t, n, m int
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	fmt.Fscan(rw, &t)
	for k := 0; k < t; k++ {
		fmt.Fscan(rw, &n)
		arr1 := make([]int, n)
		for i := 0; i < n; i++ {
			fmt.Fscan(rw, &arr1[i])
		}

		sort.Slice(arr1, func(i, j int) bool {
			return arr1[i] < arr1[j]
		})

		fmt.Fscan(rw, &m)
		arr2 := make([]int, m)
		for i := 0; i < m; i++ {
			fmt.Fscan(rw, &arr2[i])
		}

		for i := 0; i < m; i++ {
			fmt.Fprintln(rw, binarySearch(arr1, arr2[i]))
		}
	}
}
