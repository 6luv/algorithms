package main

import (
	"bufio"
	"fmt"
	"os"
)

func Y(time int) int {
	var res, div int
	div = time/30 + 1
	res += div * 10
	return res
}

func M(time int) int {
	var res, div int
	div = time/60 + 1
	res += div * 15
	return res
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, time, y, m int
	fmt.Fscan(rw, &n)
	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &time)
		y += Y(time)
		m += M(time)
	}

	if y > m {
		fmt.Printf("M %d", m)
	} else if y < m {
		fmt.Printf("Y %d", y)
	} else {
		fmt.Printf("Y M %d", y)
	}

}
