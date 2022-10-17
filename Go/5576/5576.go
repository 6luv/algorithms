package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	wScore := make([]int, 10)
	kScore := make([]int, 10)

	r := bufio.NewReader(os.Stdin)
	for i := 0; i < 20; i++ {
		if i < 10 {
			fmt.Fscan(r, &wScore[i])
		} else {
			fmt.Fscan(r, &kScore[i-10])
		}
	}
	sort.Slice(wScore, func(i, j int) bool {
		return wScore[i] > wScore[j]
	})
	sort.Slice(kScore, func(i, j int) bool {
		return kScore[i] > kScore[j]
	})

	for j := 1; j < 3; j++ {
		wScore[0] += wScore[j]
		kScore[0] += kScore[j]
	}
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	fmt.Fprintf(w, "%d %d", wScore[0], kScore[0])
}
