package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var res, slen int
	var num string
	for {
		fmt.Fscan(rw, &num)
		slen = len(num)
		if num == "0" {
			break
		}

		res += slen + 1

		cnt1 := strings.Count(num, "1")
		res += cnt1 * 2

		cnt0 := strings.Count(num, "0")
		res += cnt0 * 4

		slen = slen - cnt1 - cnt0

		fmt.Println(res + slen*3)
		res = 0
	}
}
