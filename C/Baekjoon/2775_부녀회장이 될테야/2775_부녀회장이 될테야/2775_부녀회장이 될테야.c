#include <stdio.h>
//부녀회장이 될테야

int add(int k, int n) {
	if (k == 0) { //층수가 0이면 호수 n만큼 반환
		return n;
	}
	else if (n == 1) { //호수가 1이면 1반환
		return 1;
	}
	else { //재귀함수 이용
		return add(k, n - 1) + add(k - 1, n); 
	}
}

int main() {
	int T, k, n, sum = 0;
	scanf_s("%d", &T); //테스트 케이스

	for (int i = 0; i < T; i++) { //테스트 케이스만큼 반복
		scanf_s("%d", &k); //층수
		scanf_s("%d", &n); //호수
		
		sum = add(k, n); //재귀함수
		printf("%d\n", sum); //거주민 수 출력
	}
	return 0;
}