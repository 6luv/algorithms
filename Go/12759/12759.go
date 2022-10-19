package main

import (
	"bufio"
	"fmt"
	"os"
)

func isVictory(tic [][]int, player int) int {
	if tic[0][0] == player && tic[0][1] == player && tic[0][2] == player {
		return player
	}
	if tic[1][0] == player && tic[1][1] == player && tic[1][2] == player {
		return player
	}
	if tic[2][0] == player && tic[2][1] == player && tic[2][2] == player {
		return player
	}
	if tic[0][0] == player && tic[1][0] == player && tic[2][0] == player {
		return player
	}
	if tic[0][1] == player && tic[1][1] == player && tic[2][1] == player {
		return player
	}
	if tic[0][2] == player && tic[1][2] == player && tic[2][2] == player {
		return player
	}
	if tic[0][0] == player && tic[1][1] == player && tic[2][2] == player {
		return player
	}
	if tic[0][2] == player && tic[1][1] == player && tic[2][0] == player {
		return player
	}
	return 0
}

func isFullTic(tic [][]int) bool {
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			if tic[i][j] == 0 {
				return false
			}
		}
	}
	return true
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var p, x, y, flag int
	tic := make([][]int, 3)
	for i := 0; i < 3; i++ {
		tic[i] = make([]int, 3)
	}

	fmt.Fscan(rw, &p)
	flag = p

	for i := 0; i < 9; i++ {
		fmt.Fscan(rw, &x, &y)
		tic[x-1][y-1] = flag
		res := isVictory(tic, flag)

		if res == 1 {
			fmt.Fprintln(rw, "1")
			break
		} else if res == 2 {
			fmt.Fprintln(rw, "2")
			break
		}
		if isFullTic(tic) {
			fmt.Fprintln(rw, "0")
			break
		}
		if flag == 1 {
			flag = 2
		} else {
			flag = 1
		}
	}
}
