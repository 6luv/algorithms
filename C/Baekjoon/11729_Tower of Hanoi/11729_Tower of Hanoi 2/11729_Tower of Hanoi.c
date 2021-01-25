#include <stdio.h>
//하노이탑

int power(int n) { //횟수 계산
	int i, res = 1;
	for (i = 1; i <= n; i++) {
		res *= 2;
	}
	return res - 1;
}

int hanoi(int from, int other, int to, int n) { //시작, 보조, 목표, 원판 개수
	if (n == 1) {
		printf("%d %d\n", from, to); //원판이 1개면 바로 목표기둥으로 옮김
	}
	else {
		hanoi(from, to, other, n - 1); //마지막 원판을 제외하고 나머지를 보조 기둥으로 옮김
		printf("%d %d\n", from, to); //마지막 원판 목표 기둥으로 옮김
		hanoi(other, from, to, n - 1); //마지막 원판을 제와하고 나머지를 보조 기둥에서 목표 기둥으로 옮김
	}
}

int main() {
	int n;
	scanf_s("%d", &n);
	printf("%d\n", power(n)); //총 움직힌 횟수
	hanoi(1, 2, 3, n); //함수 호출
}