#include <stdio.h>

int factorial(int n) {
	if (n == 0 || n == 1) //n�� 0�̰ų� 1�̸� 1��ȯ 
		return 1;
	else //n�� 2�̻��̸� ����Ͽ� �� ��ȯ
		return n * factorial(n - 1);
}

int main() {
	int n;
	scanf_s("%d", &n);
	printf("%d", factorial(n)); //����Լ� ����
}