package main

import "fmt"

func main() {
	var n int

	fmt.Scanf("%d", &n)
	arr := make([][2]int, n)
	for i := 0; i < n; i++ {
		fmt.Scanf("%d %d", &arr[i][0], &arr[i][1])
	}
	/*for i := 0; i < n; i++ {
		fmt.Printf("%d %d\n", arr[i][0], arr[i][1])
	}*/
}
