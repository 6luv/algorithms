package main

import (
	"bufio"
	"fmt"
	"os"
)

//원형 큐
//초기 공백 상태 : rear == front == 0
//공백 상태 : rear == front
//포화 상태 : (rear + 1) mod n == front
//삽입 위치 : rear = (rear + 1) mod n  ==> n-1번 다음 0번으로 이동
//삭제 위치 : front = (front + 1) mod n

var index = 0
var n int
var k int

type Queue struct {
	items []int
}

func (q *Queue) Enqueue(item int) {
	q.items = append(q.items, item)
}

func (q *Queue) Dequeue() int {
	index = (index + k - 1) % len(q.items)
	item := q.items[index]
	q.items = append(q.items[:index], q.items[index+1:]...)

	return item
}

func main() {
	q := Queue{}
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscan(r, &n, &k)
	for i := 1; i <= n; i++ {
		q.Enqueue(i)
	}

	for len(q.items) > 0 {
		if len(q.items) == n {
			fmt.Fprintf(w, "<%d", q.Dequeue())
		} else {
			fmt.Fprintf(w, ", %d", q.Dequeue())
		}
	}
	fmt.Fprintf(w, ">")
}
