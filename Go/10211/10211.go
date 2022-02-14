package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var t, n int
	var currentSum, maxSum int
	fmt.Fscan(rw, &t)

	for i := 0; i < t; i++ {
		fmt.Fscan(rw, &n)
		arr := make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Fscan(rw, &arr[j])
		}
		currentSum = arr[0]
		maxSum = arr[0]

		for j := 1; j < n; j++ {
			currentSum = int(math.Max(float64(arr[j]), float64(currentSum+arr[j])))
			maxSum = int(math.Max(float64(maxSum), float64(currentSum)))
		}

		fmt.Fprintln(rw, maxSum)
	}
}
