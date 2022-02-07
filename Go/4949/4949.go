package main

import (
	"bufio"
	"errors"
	"fmt"
	"os"
)

type Stack struct {
	items []rune
}

func (s *Stack) Push(item rune) {
	s.items = append(s.items, item)
}

func (s *Stack) Pop() (rune, error) {
	dLen := len(s.items)
	if dLen == 0 {
		return 0, errors.New("No Data")
	}
	item, items := s.items[dLen-1], s.items[0:dLen-1]
	s.items = items
	return item, nil
}

func main() {
	var che rune
	var flag int
	s := Stack{}
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	for {
		str, err := r.ReadString('\n')
		if str[0] == '.' {
			break
		} else {
			for i := 0; i < len(str)-1; i++ {
				if str[i] == '(' || str[i] == '[' {
					s.Push(rune(str[i]))
				} else if str[i] == ')' {
					che, err = s.Pop()
					if err != nil || che != '(' {
						flag = 1
						break
					}
				} else if str[i] == ']' {
					che, err = s.Pop()
					if err != nil || che != '[' {
						flag = 1
						break
					}
				} else {
					continue
				}
			}
			if len(s.items) == 0 && flag == 0 {
				fmt.Fprintln(w, "yes")
			} else {
				fmt.Fprintln(w, "no")
			}
			flag = 0
			for len(s.items) != 0 {
				s.Pop()
			}
		}
	}
}
