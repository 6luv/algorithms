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

	var n, m, cnt int
	var name string
	fmt.Fscan(rw, &n, &m)
	hm := make(map[string]int)
	var arr []string

	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &name)
		hm[name] = 1
	}
	for i := 0; i < m; i++ {
		fmt.Fscan(rw, &name)
		if _, ok := hm[name]; ok {
			arr = append(arr[:cnt], name)
			cnt++
		} else {
			continue
		}
	}
	sort.Strings(arr)
	fmt.Fprintln(rw, cnt)
	for i := range arr {
		fmt.Fprintln(rw, arr[i])
	}
}
