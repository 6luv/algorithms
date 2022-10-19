package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

func CountDigit(word string) int {
	var sum int
	rne := []rune(word)
	for i := 0; i < len(rne); i++ {
		if rne[i] <= '9' && rne[i] >= '0' {
			a, _ := strconv.Atoi(string(rne[i]))
			sum += a
		}
	}
	return sum
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n int
	fmt.Fscan(rw, &n)

	word := make([]string, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &word[i])
	}

	sort.Slice(word, func(i, j int) bool {
		return len(word[i]) < len(word[j])
	})

	for i := 0; i < n-1; i++ {
		for j := i + 1; j < n; j++ {
			if len(word[i]) == len(word[j]) {
				adigit := CountDigit(word[i])
				bdigit := CountDigit(word[j])
				if adigit == bdigit {
					if word[i] > word[j] {
						word[i], word[j] = word[j], word[i]
					}
				} else if adigit > bdigit {
					word[i], word[j] = word[j], word[i]
				}
			}
		}
	}
	for i := 0; i < n; i++ {
		fmt.Fprintln(rw, word[i])
	}
}
