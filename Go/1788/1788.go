package main

import (
	"bufio"
	"fmt"
	"math"
	"math/big"
	"os"
)

var dp []*big.Int

func negFibonacci(n int) *big.Int {
	zero := big.NewInt(0)
	one := big.NewInt(1)
	negone := big.NewInt(-1)
	mod := big.NewInt(1000000000)
	if n == 0 {
		return zero
	}
	if n == 1 {
		return one
	}
	if n == 2 {
		return negone
	}

	if dp[n] != nil {
		return dp[n]
	}
	n = int(math.Abs(float64(n)))
	dp[n] = new(big.Int).Sub(negFibonacci(n-2), negFibonacci(n-1))
	if dp[n].Sign() < 0 {
		dp[n] = new(big.Int).Mul(dp[n], negone)
		dp[n] = new(big.Int).Mod(dp[n], mod)
		dp[n] = new(big.Int).Mul(dp[n], negone)
	} else {
		dp[n] = new(big.Int).Mod(dp[n], mod)
	}

	return dp[n]

}

func fibonacci(n int) *big.Int {
	zero := big.NewInt(0)
	one := big.NewInt(1)
	mod := big.NewInt(1000000000)
	if n == 0 {
		return zero
	}
	if n == 1 || n == 2 {
		return one
	}
	if dp[n] != nil {
		return dp[n]
	}

	dp[n] = new(big.Int).Add(fibonacci(n-1), fibonacci(n-2))
	dp[n] = new(big.Int).Mod(dp[n], mod)
	return dp[n]
}

func main() {
	rw := bufio.NewReadWriter(bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout))
	defer rw.Flush()

	var n int
	fmt.Fscan(rw, &n)
	dp = make([]*big.Int, 10000001)
	if n < 0 {
		res := negFibonacci(int(math.Abs(float64(n))))
		if res.Sign() < 0 {
			fmt.Fprintln(rw, -1)
			res = new(big.Int).Mul(res, big.NewInt(-1))
		} else if res.Sign() > 0 {
			fmt.Fprintln(rw, 1)
		}
		fmt.Fprintln(rw, res)
	} else {
		if n == 0 {
			fmt.Fprintln(rw, 0)
		} else {
			fmt.Fprintln(rw, 1)
		}
		fmt.Fprintln(rw, fibonacci(n))
	}
}
