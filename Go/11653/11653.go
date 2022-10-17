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
	fmt.Fscan(r, &n)
	k := 2
	defer w.Flush()
	for n != 1 {
		if n%k == 0 {
			fmt.Fprintln(w, k)
			n /= k
		} else {
			k++
		}
	}
}
