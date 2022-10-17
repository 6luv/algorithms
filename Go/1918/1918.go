package main

import (
	"bufio"
	"fmt"
	"os"
)

type Stack struct {
	items []byte
	top   int
}

func (s *Stack) Push(item byte) {
	s.top++
	s.items = append(s.items, item)
}

func (s *Stack) Pop() (item byte) {
	var t byte
	if s.top != -1 {
		t = s.items[s.top]
		s.top--
		s.items = s.items[:len(s.items)-1]
	}
	return t
}

func isAlpha(item byte) int {
	if 'A' <= item && item <= 'Z' {
		return 1
	}
	return 0
}

func prec(op byte) int {
	switch op {
	case '(':
		return 0
	case '+', '-':
		return 1
	case '*', '/':
		return 2
	}
	return -1
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()
	var str string
	var tmp byte
	fmt.Fscanln(rw, &str)
	s := Stack{top: -1}
	for i := 0; i < len(str); i++ {
		if isAlpha(str[i]) == 1 {
			fmt.Fprint(rw, string(str[i]))
		} else {
			switch str[i] {
			case '(':
				s.Push(str[i])
			case '*', '/', '+', '-':
				for s.top != -1 && prec(str[i]) <= prec(s.items[s.top]) {
					tmp = s.Pop()
					if tmp != '(' || tmp != ')' {
						fmt.Fprint(rw, string(tmp))
					}
				}
				s.Push(str[i])
			case ')':
				tmp = s.Pop()
				for tmp != '(' {
					fmt.Fprint(rw, string(tmp))
					tmp = s.Pop()
				}
			}
		}
	}
	for s.top != -1 {
		fmt.Fprint(rw, string(s.Pop()))
	}
}
