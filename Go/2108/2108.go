package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
)

func findMode(arr []int) int {
	count := make([]int, 8001)
	var mode []int
	num := -4001
	max := -4000
	for i, _ := range arr {
		count[arr[i]+4000]++
		if max < count[arr[i]+4000] {
			max = count[arr[i]+4000]
		}
	}
	for i, _ := range arr {
		if max == count[arr[i]+4000] && num != arr[i] {
			mode = append(mode, arr[i])
			num = arr[i]
		}
	}

	if len(mode) > 1 {
		return mode[1]
	}
	return mode[0]
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, sum int
	fmt.Fscan(rw, &n)

	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &arr[i])
		sum += arr[i]
	}

	sort.Ints(arr)

	avr := math.Round(float64(sum) / float64(n))
	if avr == -0 {
		avr = 0
	}
	fmt.Fprintln(rw, avr)
	fmt.Fprintln(rw, arr[n/2])
	fmt.Fprintln(rw, findMode(arr))
	fmt.Fprintln(rw, arr[len(arr)-1]-arr[0])
}
