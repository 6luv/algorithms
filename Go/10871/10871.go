package main

import "fmt"

func main() {
	var N, X, num int
	var arr []int
	fmt.Scanf("%d %d", &N, &X)

	fmt.Println(arr)
	for i := 0; i < N; i++ {
		fmt.Scanf("%d", &num)
		arr = append(arr, num)
	}

	fmt.Println(arr)
	/*for j := 0; j < N; j++ {
		fmt.Printf("%d ", arr[j])
		if arr[i] < X {
			fmt.Printf("%d ", arr[i])
		}
	}*/
}
