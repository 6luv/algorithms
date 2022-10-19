package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, cnt int
	c := 665
	fmt.Fscan(rw, &n)

	for cnt < n {
		c++
		if strings.Contains(strconv.Itoa(c), "666") {
			cnt++
		}
	}

	fmt.Print(c)
}
