#include <stdio.h>
//�Ž��� ��

int main() {
	int money, count = 0;
	int change[6] = { 500, 100, 50, 10, 5, 1 }; //�Ž��� �� �迭�� ����
	scanf_s("%d", &money);
	money = 1000 - money; // 1000������ �� �� ����

	for (int i = 0; i < 6; i++) { // ū ������ ����
		if (money / change[i] >= 1) {
			count += money / change[i];
			money = money % change[i];
		}
	}
	printf("%d", count);
}