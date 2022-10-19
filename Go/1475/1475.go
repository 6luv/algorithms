package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func checkSet(number string) int {
	var max int
	c := []rune(number)
	res := make([]int, 9)

	for i := 0; i < len(number); i++ {
		if c[i] == '6' || c[i] == '9' {
			res[6] += 1
		} else {
			index, _ := strconv.Atoi(string(c[i]))
			res[index] += 1
		}
	}
	if res[6]%2 != 0 {
		res[6] /= 2
		res[6] = int(math.Round(float64(res[6]) + 0.5))
	} else {
		res[6] /= 2
	}

	for i := 0; i < 9; i++ {
		if max < res[i] {
			max = res[i]
		}
	}
	return max
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var number string
	fmt.Fscan(rw, &number)
	fmt.Fprintln(rw, checkSet(number))

}
