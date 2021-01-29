#include <stdio.h>
//거스름 돈

int main() {
	int money, count = 0;
	int change[6] = { 500, 100, 50, 10, 5, 1 }; //거스름 돈 배열에 저장
	scanf_s("%d", &money);
	money = 1000 - money; // 1000원에서 뺀 값 저장

	for (int i = 0; i < 6; i++) { // 큰 수부터 나눔
		if (money / change[i] >= 1) {
			count += money / change[i];
			money = money % change[i];
		}
	}
	printf("%d", count);
}