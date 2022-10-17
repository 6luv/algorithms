package main

import (
	"bufio"
	"fmt"
	"os"
)

var rw = bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))

type Queue struct {
	items []int
}

func (q *Queue) Enqueue(item int) {
	q.items = append(q.items, item)
}

func (q *Queue) Dequeue() int {
	fmt.Fprintf(rw, "%d ", q.items[0])
	q.items = append(q.items[1:])
	tmp := q.items[0]
	q.items = append(q.items[1:])
	return tmp
}

func main() {

	defer rw.Flush()

	q := Queue{}
	var n, tmp int
	fmt.Fscan(rw, &n)
	for i := 1; i <= n; i++ {
		q.Enqueue(i)
	}
	for len(q.items) != 1 {
		tmp = q.Dequeue()
		q.Enqueue(tmp)
	}
	fmt.Fprint(rw, q.items[0])
}
