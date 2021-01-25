#include <stdio.h>
//벌집

int main() {
	int n, i, a = 1, count = 1; //a 첫 항, count 몇 번 이동하는지 초기화
	scanf_s("%d", &n);

	for (i = 1; i <= n; i++) {
		if (a >= n) { //입력한 수보다 같거나 커지면 종료
			break;
		}
		else { 
			a += 6 * i; //공차 6이 공비 i에 따라 증가
			count += 1; //더할 때마다 한 번 씩 이동
		}
	}
	printf("%d", count); //횟수 출력
}