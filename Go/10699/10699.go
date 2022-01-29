package main

import (
	"fmt"
	"time"
)

func main() {
	today := time.Now().UTC()
	custom := today.Format("2006-01-02")
	fmt.Println(custom)
}
