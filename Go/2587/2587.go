package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var sum int
	arr := make([]int, 5)
	for i := 0; i < 5; i++ {
		fmt.Fscan(rw, &arr[i])
		sum += arr[i]
	}

	sort.Ints(arr)
	fmt.Fprintln(rw, sum/5)
	fmt.Fprintln(rw, arr[2])
}
