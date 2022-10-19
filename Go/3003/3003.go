package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	chess := []int{1, 1, 2, 2, 2, 8}
	var input = make([]int, 6)
	var num int

	for i := 0; i < 6; i++ {
		fmt.Scanf("%d", &num)
		input[i] = num
		input[i] = chess[i] - input[i]
	}

	for i := 0; i < 6; i++ {
		fmt.Printf("%d ", input[i])
	}

}
