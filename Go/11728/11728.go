package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	var n, m int
	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &n, &m)
	a := make([]int, n)
	b := make([]int, m)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &a[i])
	}
	for j := 0; j < m; j++ {
		fmt.Fscan(r, &b[j])
	}

	a = append(a, b...)

	sort.Slice(a, func(i, j int) bool {
		return a[i] < a[j]
	})

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	for k := 0; k < len(a); k++ {
		fmt.Fprintf(w, "%d ", a[k])
	}
}
