package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

func IncSortNum(num string) string {
	so := []rune(num)
	sort.Slice(so, func(i int, j int) bool {
		return so[i] < so[j]
	})
	res := string(so)
	return res
}

func DecSortNum(num string) string {
	so := []rune(num)
	sort.Slice(so, func(i int, j int) bool {
		return so[i] > so[j]
	})
	res := string(so)
	return res
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var t, count, x, y, xy int
	var num string
	fmt.Fscan(rw, &t)

	for i := 0; i < t; i++ {
		fmt.Fscan(rw, &num)
		xy, _ = strconv.Atoi(num)
		for {
			if xy == 6174 {
				fmt.Fprintln(rw, count)
				break
			}
			x, _ = strconv.Atoi(IncSortNum(num))
			y, _ = strconv.Atoi(DecSortNum(num))

			xy = y - x
			num = strconv.Itoa(xy)
			if len(num) == 3 {
				xy *= 10
				num = strconv.Itoa(xy)
			}

			count += 1
		}
		count = 0
	}
}
