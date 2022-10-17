package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	alpha := make([]int, 26)
	var word string
	r := bufio.NewReader(os.Stdin)
	fmt.Fscan(r, &word)

	for i := 0; i < len(word); i++ {
		alpha[word[i]-'a']++
	}

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	for i := 0; i < 26; i++ {
		fmt.Fprintf(w, "%d ", alpha[i])
	}
}
