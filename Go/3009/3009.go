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

	x := make([]int, 3)
	y := make([]int, 3)
	for i := 0; i < 3; i++ {
		fmt.Fscanln(rw, &x[i], &y[i])
	}

	sort.Slice(x, func(i, j int) bool {
		return x[i] < x[j]
	})

	sort.Slice(y, func(i, j int) bool {
		return y[i] < y[j]
	})

	if x[0] != x[1] {
		fmt.Fprintf(rw, "%d ", x[0])
	} else {
		fmt.Fprintf(rw, "%d ", x[2])
	}
	if y[0] != y[1] {
		fmt.Fprint(rw, y[0])
	} else {
		fmt.Fprint(rw, y[2])
	}
}
