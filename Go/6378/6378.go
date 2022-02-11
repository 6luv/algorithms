package main

import (
	"bufio"
	"fmt"
	"os"
	strconv "strconv"
)

func main() {
	var sum, n int
	var num string
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	for {
		fmt.Fscan(rw, &num)
		if num == "0" {
			break
		}
		for len(num) != 1 {
			sum = 0
			for i := range num {
				n, _ = strconv.Atoi(string(num[i]))
				sum += n
			}
			if sum < 10 {
				break
			} else {
				num = strconv.Itoa(sum)
			}
		}
		if len(num) == 1 {
			sum, _ = strconv.Atoi(num)
		}

		fmt.Fprintln(rw, sum)
		sum = 0
	}
}
