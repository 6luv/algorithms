package main

import (
	"fmt"
)

func main() {
	var num = []int{3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10}
	var word string
	var sum int

	fmt.Scanf("%s", &word)
	for i := 0; i < len(word); i++ {
		sum += num[int(word[i])-65]
	}
	fmt.Println(sum)
}
