package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func binarySearch(h []int, n int, m int) int {
	var res int
	var sum int64
	min := 100000000000000
	low := 0            //0
	high := h[len(h)-1] //20
	for low <= high {
		mid := (low + high) / 2 //10
		for i := 0; i < n; i++ {
			if h[i] > mid {
				sum += int64(h[i] - mid)
			}
		}
		if sum >= int64(m) {
			low = mid + 1
			if int64(min) > sum {
				min = int(sum)
				res = mid
			}
		} else if sum < int64(m) {
			high = mid - 1
		}
		sum = 0
	}
	return res
}

func main() {
	var n, m int
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscan(r, &n, &m)
	height := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &height[i])
	}

	sort.Slice(height, func(i, j int) bool {
		return height[i] < height[j]
	})

	res := binarySearch(height, n, m)
	fmt.Fprintln(w, res)

}
