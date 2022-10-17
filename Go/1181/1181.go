package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func remove(slice []string, s int) []string {
	return append(slice[:s], slice[s+1:]...)
}

func main() {
	var n int
	fmt.Scanln(&n)
	r := bufio.NewReader(os.Stdin)
	word := make([]string, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &word[i])
	}

	sort.Slice(word, func(i, j int) bool {
		if len(word[i]) == len(word[j]) {
			return word[i] < word[j]
		}
		return len(word[i]) < len(word[j])
	})

	for i := 0; i < len(word)-1; i++ {
		if word[i] == word[i+1] {
			word = remove(word, i)
			i--
		}
	}

	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	for i := 0; i < len(word); i++ {
		fmt.Fprintln(w, word[i])
	}
}
