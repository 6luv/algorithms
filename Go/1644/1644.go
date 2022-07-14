package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, count int
	fmt.Fscan(rw, &n)
	arr := make([]int, n+1)

	for i := 2; i <= n; i++ {
		arr[i] = i
	}

	for i := 2; i <= n; i++ {
		if arr[i] == 0 {
			continue
		}

		for j := i * 2; j <= n; j += i {
			arr[j] = 0
		}
	}

	start := 2
	end := 2
	sum := 0

	for {
		if start == len(arr) && end == len(arr) {
			break
		}
		if sum < n && end != len(arr) {
			if arr[end] != 0 {
				sum += arr[end]
				end++
			} else {
				end++
			}
		} else {
			if arr[start] != 0 {
				if sum == n {
					count++
				}
				sum -= arr[start]
				start++
			} else {
				start++
			}

		}
	}
	fmt.Println(count)
}
