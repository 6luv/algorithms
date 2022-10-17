package main

import (
	"bufio"
	"errors"
	"fmt"
	"os"
)

//int 배열을 저장하는 스택 구조 정의
type Stack struct {
	items []int
}

//데이터 저장 -> int[] 배열에 값 추가
func (s *Stack) Push(item int) {
	s.items = append(s.items, item)
}

//데이터 추출 -> 길이가 0이면 에러
//0보다 크면 마지막 값 반환, 기촌 int 배열에 마지막 값을 빼 배열로 대체
func (s *Stack) Pop() (int, error) {
	dLen := len(s.items)
	if dLen == 0 {
		return -1, errors.New("No Data")
	}
	item, items := s.items[dLen-1], s.items[0:dLen-1]
	s.items = items
	return item, nil
}

func main() {
	s := Stack{}
	var k, num, sum int
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscan(r, &k)

	for i := 0; i < k; i++ {
		fmt.Fscan(r, &num)
		if num == 0 {
			s.Pop()
		} else {
			s.Push(num)
		}
	}

	for range s.items {
		if item, err := s.Pop(); err != nil {
			fmt.Fprintln(w, err)
		} else {
			sum += item
		}
	}
	fmt.Fprintln(w, sum)
}
