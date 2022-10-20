package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

var arr []int

func findHouse(mid int) int {
	var count int

	first := arr[0]
	count = 1

	for i := 1; i < len(arr); i++ {
		next := arr[i]

		if next-first >= mid {
			count++
			first = next
		}
	}
	return count
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, c, mid, min, max int
	fmt.Fscan(rw, &n, &c)

	arr = make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &arr[i])
		if max < arr[i] {
			max = arr[i]
		}
	}
	sort.Slice(arr, func(i, j int) bool {
		return arr[i] < arr[j]
	})

	for min < max {
		mid = (min + max) / 2

		if findHouse(mid) < c {
			max = mid
		} else {
			min = mid + 1
		}
	}
	fmt.Fprintln(rw, min-1)

}
