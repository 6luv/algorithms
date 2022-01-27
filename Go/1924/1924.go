package main

import "fmt"

func main() {
	var x, y, sum int
	fmt.Scanf("%d %d", &x, &y)
	for i := 1; i < x; i++ {
		switch i {
		case 1, 3, 5, 7, 8, 10, 12:
			sum += 31
		case 4, 6, 9, 11:
			sum += 30
		case 2:
			sum += 28
		}
	}

	sum += y
	switch sum % 7 {
	case 1:
		fmt.Println("MON")
	case 2:
		fmt.Println("TUE")
	case 3:
		fmt.Println("WED")
	case 4:
		fmt.Println("THU")
	case 5:
		fmt.Println("FRI")
	case 6:
		fmt.Println("SAT")
	case 0:
		fmt.Println("SUN")
	}
}
