package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func reverse(num []rune) string {
	var res []rune
	for i := len(num) - 1; i >= 0; i-- {
		res = append(res, num[i])
	}
	return string(res)
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var x, y, xy string
	fmt.Fscan(rw, &x, &y)

	rx := []rune(x)
	ry := []rune(y)
	x = reverse(rx)
	y = reverse(ry)

	nx, _ := strconv.Atoi(x)
	ny, _ := strconv.Atoi(y)

	xy = strconv.Itoa(nx + ny)
	reanswer := []rune(xy)
	xy = reverse(reanswer)
	answer, _ := strconv.Atoi(xy)

	fmt.Fprintln(rw, answer)
}
