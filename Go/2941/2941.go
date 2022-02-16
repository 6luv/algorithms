package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	var str string

	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()
	fmt.Fscan(rw, &str)
	str = strings.Replace(str, "c=", "@", -1)
	str = strings.Replace(str, "c-", "@", -1)
	str = strings.Replace(str, "dz=", "@", -1)
	str = strings.Replace(str, "d-", "@", -1)
	str = strings.Replace(str, "lj", "@", -1)
	str = strings.Replace(str, "nj", "@", -1)
	str = strings.Replace(str, "s=", "@", -1)
	str = strings.Replace(str, "z=", "@", -1)
	fmt.Fprintln(rw, len(str))
}
