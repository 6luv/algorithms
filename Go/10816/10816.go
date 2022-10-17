package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func upperBound(arr []int, front int, rear int, key int) int { //key 보다 큰 첫 번째 위치 반환
	for front < rear {
		mid := (front + rear) / 2
		if arr[mid] <= key { //key 보다 작거나 같으면
			front = mid + 1
		} else { //key 보다 크면
			rear = mid
		}
	}
	if arr[rear] == key {
		rear++
	}
	return rear
}

func lowerBound(arr []int, front int, rear int, key int) int { //key 보다 크거나 같은 첫 번째 위치 반환
	for front < rear {
		mid := (front + rear) / 2
		if arr[mid] < key { //key 보다 작으면
			front = mid + 1
		} else { //key 보다 크거나 같으면
			rear = mid
		}
	}
	return rear
}

func main() {
	var n, m int
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	fmt.Fscanln(r, &n)
	arr1 := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr1[i])
	}

	sort.Slice(arr1, func(i, j int) bool {
		return arr1[i] < arr1[j]
	})

	fmt.Fscan(r, &m)
	arr2 := make([]int, m)

	for i := 0; i < m; i++ {
		fmt.Fscan(r, &arr2[i])
	}

	for i := 0; i < m; i++ {
		fmt.Fprintf(w, "%d ", upperBound(arr1, 0, len(arr1)-1, arr2[i])-lowerBound(arr1, 0, len(arr1)-1, arr2[i]))
	}
}
