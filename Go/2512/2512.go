package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, max, min, mid, sum, maxMoney, res int
	fmt.Fscan(rw, &n)
	arr := make([]int, n)

	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &arr[i])
		if max < arr[i] {
			max = arr[i]
		}
		sum += arr[i]
	}
	fmt.Fscan(rw, &maxMoney)

	for min <= max {
		mid = (min + max) / 2
		sum = 0
		for i := 0; i < len(arr); i++ {
			if arr[i] < mid {
				sum += arr[i]
			} else {
				sum += mid
			}
		}
		if sum > maxMoney {
			max = mid - 1
		} else {
			min = mid + 1
			res = mid
		}
	}

	fmt.Fprintln(rw, res)
}
