#include <stdio.h>
//����Լ��� �̿��� �Ǻ���ġ ����

int fibonacci(int n) {
	if (n == 0) //n�� 0�̸� 0��ȯ
		return 0;
	else if (n == 1 || n == 2) //n�� 1�̳� 2�̸� 1��ȯ
		return 1;
	else
		return(fibonacci(n - 1) + fibonacci(n - 2));
	// n�� 2 �̻��̸� ����Լ��� �� ����
}

int main() {
	int n;
	scanf_s("%d", &n);
	printf("%d", fibonacci(n)); //����Լ� ����

}