package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	scn := bufio.NewScanner(os.Stdin)
	var arr []string
	var num, sum, min, flag int
	min = 100
	flag = 1
	for i := 0; i < 7; i++ {
		scn.Scan()
		arr = append(arr, scn.Text())
	}

	for i := 0; i < 7; i++ {
		num, _ = strconv.Atoi(arr[i])
		if num%2 != 0 || num == 1 {
			sum += num
			if min > num {
				min = num
			}
			flag = 0
		}
	}
	if flag == 1 {
		fmt.Printf("-1")
	} else {
		fmt.Printf("%d\n%d", sum, min)
	}
}
