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
	var n, cnt, flag int

	fmt.Fscanln(rw, &n)
	for i := 0; i < n; i++ {
		word, _ := rw.ReadString('\n')
		word = strings.TrimSuffix(word, "\n")
		flag = 0
		for j := 0; j < len(word)-2; j++ {
			for k := j + 2; k < len(word); k++ {
				if word[j] == word[k] && word[j] != word[j+1] {
					flag = 1
					break
				} else {
					flag = 0
				}
			}
			if flag == 1 {
				break
			}
		}
		if flag == 0 {
			cnt++
		}
	}
	fmt.Fprintln(rw, cnt)

}
