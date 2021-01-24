#include <stdio.h>

int factorial(int n) {
	if (n == 0 || n == 1) //n이 0이거나 1이면 1반환 
		return 1;
	else //n이 2이상이면 재귀하여 값 반환
		return n * factorial(n - 1);
}

int main() {
	int n;
	scanf_s("%d", &n);
	printf("%d", factorial(n)); //재귀함수 실행
}