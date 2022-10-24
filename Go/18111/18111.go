package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

func check(mat [][]int, n, m, b, lv int) int {
	var sc, c int
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			z := mat[i][j] - lv
			if z > 0 {
				b += z
				sc += 2 * z
			} else {
				c += -z
			}
		}
	}
	if b < c {
		return 10e9
	} else {
		return sc + c
	}
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, m, b int
	msc := math.MaxInt64
	mlv := 0
	mat := make([][]int, 500)
	for i := 0; i < 500; i++ {
		mat[i] = make([]int, 500)
	}

	fmt.Fscan(rw, &n, &m, &b)

	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			fmt.Fscan(rw, &mat[i][j])
		}
	}

	for i := 256; i > -1; i-- {
		sc := check(mat, n, m, b, i)
		if msc > sc {
			msc = sc
			mlv = i
		}
	}
	fmt.Fprintln(rw, msc, mlv)
}
