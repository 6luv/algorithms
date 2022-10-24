package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

var set []string

func add(num string) {
	set = append(set, num)
}

func remove(num string) {
	for i, v := range set {
		if v == num {
			set = append(set[:i], set[i+1:]...)
			return
		}
	}
}

func check(num string) int {
	for _, v := range set {
		if v == num {
			return 1
		}
	}
	return 0
}

func toggle(num string) {
	for _, v := range set {
		if v == num {
			remove(num)
			return
		}
	}
	add(num)
}

func all() {
	set = []string{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n int
	var word string
	order := make([]string, 2)
	fmt.Fscan(rw, &n)
	rw.ReadString('\n')
	for i := 0; i < n; i++ {

		word, _ = rw.ReadString('\n')
		word = strings.TrimRight(word, "\r\n")
		token := strings.Split(word, " ")

		for i, v := range token {
			order[i] = v
		}
		switch order[0] {
		case "add":
			add(order[1])
		case "remove":
			remove(order[1])
		case "check":
			if check(order[1]) == 1 {
				fmt.Fprintln(rw, "1")
			} else {
				fmt.Fprintln(rw, "0")
			}
		case "toggle":
			toggle(order[1])
		case "all":
			all()
		case "empty":
			set = nil
		}
	}
}
