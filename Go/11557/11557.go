package main

import (
	"bufio"
	"fmt"
	"os"
)

type School struct {
	school string
	l      int
}

func main() {
	var t, n int
	var max School

	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &t)
	for i := 0; i < t; i++ {
		fmt.Fscan(r, &n)
		p := make([]School, n)
		for j := 0; j < n; j++ {
			fmt.Fscan(r, &p[j].school, &p[j].l)
			if max.l < p[j].l {
				max.school = p[j].school
				max.l = p[j].l
			}
		}

		fmt.Println(max.school)
	}
}
