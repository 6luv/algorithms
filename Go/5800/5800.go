package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	var class, stu, gap int
	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &class)

	for i := 0; i < class; i++ {
		fmt.Fscan(r, &stu)
		score := make([]int, stu)
		for j := 0; j < stu; j++ {
			fmt.Fscan(r, &score[j])
		}
		sort.Slice(score, func(i, j int) bool {
			return score[i] > score[j]
		})
		for k := 0; k < stu-1; k++ {
			if score[k]-score[k+1] > gap {
				gap = score[k] - score[k+1]
			}
		}

		fmt.Printf("Class %d\n", i+1)
		fmt.Printf("Max %d, Min %d, Largest gap %d\n", score[0], score[len(score)-1], gap)
		gap = 0
	}
}
