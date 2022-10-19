<<<<<<< HEAD
package _568
=======
package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var n int
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscan(r, &n)
	we := make([]int, n)
	hi := make([]int, n)
	gr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &we[i], &hi[i])
	}

	for i := 0; i < n; i++ {
		gr[i]++
		for j := 0; j < n; j++ {
			if we[i] > we[j] && hi[i] > hi[j] {
				gr[j]++
			}
		}
	}

	for i := 0; i < n; i++ {
		fmt.Fprintf(w, "%d ", gr[i])
	}
}
>>>>>>> e29607c422b13c403c4eadafce6eaaf822511122
