package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var n, m, wmin, bmin int
	cnt := 100
	white := [8][8]string{
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
	}
	black := [8][8]string{
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
		{"B", "W", "B", "W", "B", "W", "B", "W"},
		{"W", "B", "W", "B", "W", "B", "W", "B"},
	}
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()
	fmt.Fscan(r, &n, &m)
	var str string
	arr := make([][]string, n)
	for i := range arr {
		arr[i] = make([]string, m)
	}

	for i := 0; i < n; i++ {
		fmt.Fscan(r, &str)
		for j := 0; j < m; j++ {
			arr[i][j] = string(str[j])
		}
	}

	for y := 0; y < n-7; y++ {
		for x := 0; x < m-7; x++ {
			wmin = 0
			bmin = 0
			for i := 0; i < 8; i++ {
				for j := 0; j < 8; j++ {
					if arr[i+y][j+x] != white[i][j] {
						wmin++
					}
					if arr[i+y][j+x] != black[i][j] {
						bmin++
					}
				}
			}
			if wmin < cnt {
				cnt = wmin
			}
			if bmin < cnt {
				cnt = bmin
			}
		}
	}
	fmt.Fprintln(w, cnt)
}
