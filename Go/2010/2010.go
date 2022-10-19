package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, num, res int
	fmt.Fscan(rw, &n)

	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &num)
		res += num
	}

	fmt.Println(res - (n - 1))
}
