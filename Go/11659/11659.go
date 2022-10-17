package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var n, m, l, k int
	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &n, &m)
	arr := make([]int, n+1)
	for i := 1; i <= n; i++ {
		fmt.Fscan(r, &arr[i])
		arr[i] = arr[i-1] + arr[i]
	}

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	for j := 0; j < m; j++ {
		fmt.Fscan(r, &l, &k)
		if l == 1 {
			fmt.Fprintln(w, arr[k])
		} else {
			fmt.Fprintln(w, arr[k]-arr[l-1])
		}
	}
}
