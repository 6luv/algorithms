package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	var n int
	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &n)
	arr := make([]int, 10)
	for i := 0; i < n; i++ {
		for j := 0; j < 10; j++ {
			fmt.Fscan(r, &arr[j])
		}
		sort.Slice(arr, func(i, j int) bool {
			return arr[i] > arr[j]
		})

		fmt.Printf("%d\n", arr[2])
	}
}
