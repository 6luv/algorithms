package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n, num, check, money, max int
	dice := map[int]int{
		0: 0,
		1: 0,
		2: 0,
		3: 0,
		4: 0,
		5: 0,
		6: 0,
	}
	fmt.Fscan(rw, &n)

	for i := 0; i < n; i++ {
		for j := 0; j < 3; j++ {
			fmt.Fscan(rw, &num)
			dice[num] += 1
		}
		for j := 0; j < 7; j++ {
			if dice[j] == 3 {
				money = 10000 + j*1000
				break
			} else if dice[j] == 2 {
				money = 1000 + j*100
				break
			} else {
				if check < j {
					check = j
					money = check * 100
				}
			}
		}
		if money > max {
			max = money
		}
		for j := 0; j < 7; j++ {
			dice[j] = 0
		}
	}
	fmt.Fprint(rw, max)
}
