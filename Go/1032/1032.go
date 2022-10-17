package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n int

	var preword, word string

	fmt.Fscan(rw, &n)

	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &word)
		if i == 0 || n == 1 {
			preword = word
		}
		for j := 0; j < len(word); j++ {
			if preword[j] != word[j] {
				res := []rune(preword)
				res[j] = '?'
				preword = string(res)
			}
		}
	}
	fmt.Fprintln(rw, preword)
}
