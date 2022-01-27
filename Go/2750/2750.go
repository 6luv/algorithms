package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

func main() {
	scn := bufio.NewScanner(os.Stdin)
	var n string
	var arr []string
	var arr2 = []int{}

	fmt.Scanln(&n)               //엔터 기준으로 한줄씩 스캔
	length, _ := strconv.Atoi(n) //데이터 정수 변환

	for i := 0; i < length; i++ {
		scn.Scan()
		arr = append(arr, scn.Text()) //스캔된 입력 값
	}

	for _, i := range arr {
		j, err := strconv.Atoi(i)
		if err != nil {
			panic(err)
		}
		arr2 = append(arr2, j)
	}
	sort.Ints(arr2)

	for i := 0; i < length; i++ {
		fmt.Println(arr2[i])
	}
}
