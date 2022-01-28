package main

import "fmt"

func main() {
	var n, cnt, num int
	var arr []int
	fmt.Scanf("%d", &n)
	for i := 0; i < 5; i++ {
		fmt.Scanf("%d", &num)
		arr = append(arr, num)
	}
	fmt.Println(arr)
	for i := 0; i < 5; i++ {
		if arr[i] == n {
			cnt++
		}
	}
	fmt.Println(cnt)
}
