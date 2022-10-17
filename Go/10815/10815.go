package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func binarySearch(arr1 []int, num int) int {
	low := 0
	high := len(arr1) - 1
	for low <= high {
		mid := (low + high) / 2
		if arr1[mid] == num {
			return 1
		} else if arr1[mid] < num {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return 0
}

func main() {
	var n, m int
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscanln(r, &n)
	arr1 := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr1[i])
	}

	sort.Slice(arr1, func(i, j int) bool {
		return arr1[i] < arr1[j]
	})

	fmt.Fscan(r, &m)
	arr2 := make([]int, m)

	for i := 0; i < m; i++ {
		fmt.Fscan(r, &arr2[i])
	}

	for j := 0; j < m; j++ {
		fmt.Fprintf(w, "%d ", binarySearch(arr1, arr2[j]))
	}

}
