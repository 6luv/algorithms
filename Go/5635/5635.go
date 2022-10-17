package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

type Info struct {
	name       string
	dd, mm, yy int
}

func main() {
	var n int
	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &n)
	p := make([]Info, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &p[i].name, &p[i].dd, &p[i].mm, &p[i].yy)
	}

	sort.Slice(p, func(i, j int) bool {
		if p[i].yy == p[j].yy {
			if p[i].mm == p[j].mm {
				return p[i].dd > p[j].dd
			}
			return p[i].mm > p[j].mm
		}
		return p[i].yy > p[j].yy
	})

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	fmt.Fprintln(w, p[0].name)
	fmt.Fprintln(w, p[n-1].name)
}
