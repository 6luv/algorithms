package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, max int
	fmt.Fscan(rw, &n)
	arr := make([]int, n)
	sum := make([]int, n)

	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &arr[i])
	}
	sum[0] = arr[0]
	max = arr[0]
	for i := 1; i < n; i++ {
		if sum[i-1]+arr[i] > arr[i] {
			sum[i] = sum[i-1] + arr[i]
		} else {
			sum[i] = arr[i]
		}
	}
	for i := 1; i < len(sum); i++ {
		if max < sum[i] {
			max = sum[i]
		}
	}
	fmt.Println(max)
}
