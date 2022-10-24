package main

import (
	"bufio"
	"fmt"
	"os"
)

type stack []int

func (s *stack) top() int {
	if s.empty() == 0 {
		top := len(*s) - 1
		data := (*s)[top]
		return data
	} else {
		return -1
	}
}

func (s *stack) size() int {
	data := len(*s)
	return data
}

func (s *stack) empty() int {
	if len(*s) == 0 {
		return 1
	} else {
		return 0
	}
}

func (s *stack) push(data int) {
	*s = append(*s, data)

}

func (s *stack) pop() int {
	if s.empty() == 1 {
		return -1
	} else {
		top := len(*s) - 1
		data := (*s)[top]
		*s = (*s)[:top]
		return data
	}
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var s stack
	var n, num int
	count := 1
	var res []string
	fmt.Fscan(rw, &n)

	arr := make([]int, n+1)
	for i := 0; i < n; i++ {
		fmt.Fscan(rw, &num)
		for j := count; j <= num; j++ {
			if arr[j] == 0 {
				arr[j] = j
				s.push(j)
				res = append(res, "+")
			}
		}
		count = num
		for s.top() == num {
			s.pop()
			res = append(res, "-")
		}
	}
	if s.size() != 0 {
		fmt.Fprintln(rw, "NO")
	} else {
		for _, v := range res {
			fmt.Fprintln(rw, v)
		}
	}
}
