package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var n, cnt int
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscan(r, &n)
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr[i])
	}

	stick := arr[len(arr)-1]

	for j := n - 2; j >= 0; j-- {
		if stick < arr[j] {
			cnt++
			stick = arr[j]
		}
	}
	fmt.Fprintln(w, cnt+1)
}
