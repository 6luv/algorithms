package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func binarySearch(arr1 []int, arr2 int) int {
	//mid :=
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
	for j := 0; j < n; j++ {
		fmt.Fscan(r, &arr2[j])
	}

	sort.Ints(arr1)
	for i := 0; i < m; i++ {
		if binarySearch(arr1, arr2[i]) {

		}
	}

}
