package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var k, n int
	var max, min, mid, count uint64
	//min = 10000
	fmt.Fscan(rw, &k, &n)
	arr := make([]uint64, k)

	for i := 0; i < k; i++ {
		fmt.Fscan(rw, &arr[i])
		if max < arr[i] {
			max = arr[i]
		}
	}

	max++

	for min < max {
		mid = (max + min) / 2

		count = 0
		for i := 0; i < k; i++ {
			count += arr[i] / mid
		}

		if count < uint64(n) {
			max = mid
		} else {
			min = mid + 1
		}
	}
	fmt.Fprintln(rw, min-1)

}
