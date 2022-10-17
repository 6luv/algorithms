package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
<<<<<<< HEAD
	var m, n int
	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &m, &n)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	for i := m; i <= n; i++ {
		for j := 2; j*j <= i; j++ {
			if i%j == 0 {
				break
			}
=======
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, m int

	fmt.Fscan(rw, &n, &m)
	arr := make([]int, m+1)

	for i := 2; i <= m; i++ {
		arr[i] = i
	}

	for i := 2; i <= m; i++ {
		if arr[i] == 0 {
			continue
		}
		for j := i * 2; j <= m; j += i {
			arr[j] = 0
		}
	}

	for i := n; i <= m; i++ {
		if arr[i] != 0 {
			fmt.Println(arr[i])
>>>>>>> e29607c422b13c403c4eadafce6eaaf822511122
		}
	}
}
