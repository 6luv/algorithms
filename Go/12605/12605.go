package main

import (
	"bufio"
	"errors"
	"fmt"
	"os"
	"strings"
)

type Stcak struct {
	items []string
}

func (s *Stcak) Push(item string) {
	s.items = append(s.items, item)
}

func (s *Stcak) Pop() (string, error) {
	dLen := len(s.items)
	if dLen == 0 {
		return "0", errors.New("No Data")
	}
	item, items := s.items[dLen-1], s.items[0:dLen-1]
	s.items = items
	return item, nil
}

func (s *Stcak) Size() int {
	return len(s.items)
}

func main() {
	s := Stcak{}
	var n int
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscanln(r, &n)
	for i := 0; i < n; i++ {
		str, err := r.ReadString('\n')
		str = strings.TrimSuffix(str, "\n")
		if err != nil {
			fmt.Fprintln(w, err)
		}

		slice := strings.Split(str, " ")
		for _, r := range slice {
			s.Push(r)
		}

		fmt.Fprintf(w, "Case #%d: ", i+1)
		for s.Size() != 0 {
			c, err := s.Pop()
			if err != nil {
				fmt.Fprintln(w, err)
			}
			fmt.Fprintf(w, "%s ", c)
		}
		fmt.Fprint(w, "\n")
	}
}
