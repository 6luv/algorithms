package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, num, cnt, sum int
	fmt.Fscan(rw, &n)
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &num)
		arr[i] = num
	}
	for i := 1; i < n; i++ {
		if arr[i-1] == 1 && arr[i] == 1 {
			cnt += 1
		} else {
			cnt = 0
		}
		sum += arr[i] + cnt
	}
	fmt.Fprint(rw, sum+arr[0])
}
