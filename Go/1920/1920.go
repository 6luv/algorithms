package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

<<<<<<< HEAD
func binarySearch(arr1 []int, arr2 int) int {
	//mid :=
=======
func binarySearch(arr1 []int, num int) int {
	low := 0
	high := len(arr1) - 1
	for low <= high {
		mid := (low + high) / 2
		if arr1[mid] == num { //같으면
			return 1
		} else if arr1[mid] < num { //오른쪽에 있으면
			low = mid + 1
		} else { //왼쪽에 있으면
			high = mid - 1
		}
	}
	return 0
>>>>>>> e29607c422b13c403c4eadafce6eaaf822511122
}

func main() {
	var n, m int
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscan(r, &n)
	arr1 := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr1[i])
	}

	fmt.Fscan(r, &m)
	arr2 := make([]int, m)
<<<<<<< HEAD
	for j := 0; j < n; j++ {
		fmt.Fscan(r, &arr2[j])
	}

	sort.Ints(arr1)
	for i := 0; i < m; i++ {
		if binarySearch(arr1, arr2[i]) {

		}
	}

=======
	for j := 0; j < m; j++ {
		fmt.Fscan(r, &arr2[j])
	}

	sort.Slice(arr1, func(i, j int) bool {
		return arr1[i] < arr1[j]
	})
	for i := 0; i < m; i++ {
		if binarySearch(arr1, arr2[i]) == 1 {
			fmt.Fprintln(w, "1")
		} else {
			fmt.Fprintln(w, "0")
		}
	}
>>>>>>> e29607c422b13c403c4eadafce6eaaf822511122
}
