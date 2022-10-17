package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
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
		}
	}
}
