#include <stdio.h>
//재귀함수를 이용한 피보나치 수열

int fibonacci(int n) {
	if (n == 0) //n이 0이면 0반환
		return 0;
	else if (n == 1 || n == 2) //n이 1이나 2이면 1반환
		return 1;
	else
		return(fibonacci(n - 1) + fibonacci(n - 2));
	// n이 2 이상이면 재귀함수로 값 구함
}

int main() {
	int n;
	scanf_s("%d", &n);
	printf("%d", fibonacci(n)); //재귀함수 실행

}