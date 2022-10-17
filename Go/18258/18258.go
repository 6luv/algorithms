package main

import (
	"bufio"
	"fmt"
	"os"
)

type Queue struct {
	items []int
}

func (q *Queue) Push(item int) {
	q.items = append(q.items, item)
}

func (q *Queue) Pop() int {
	qLen := len(q.items)
	if qLen == 0 {
		return -1
	}
	item, items := q.items[0], q.items[1:qLen]
	q.items = items
	return item
}

func (q *Queue) Size() int {
	return len(q.items)
}

func (q *Queue) Empty() int {
	if len(q.items) == 0 {
		return 1
	} else {
		return 0
	}
}

func (q *Queue) Front() int {
	if len(q.items) == 0 {
		return -1
	}
	return q.items[0]
}

func (q *Queue) Back() int {
	if len(q.items) == 0 {
		return -1
	}
	return q.items[len(q.items)-1]
}

func main() {
	var n, num int
	var str string
	q := Queue{}
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscan(r, &n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &str)
		switch str {
		case "push":
			fmt.Fscanln(r, &num)
			q.Push(num)
		case "pop":
			fmt.Fprintln(w, q.Pop())
		case "size":
			fmt.Fprintln(w, q.Size())
		case "empty":
			fmt.Fprintln(w, q.Empty())
		case "front":
			fmt.Fprintln(w, q.Front())
		case "back":
			fmt.Fprintln(w, q.Back())
		}
	}

}
