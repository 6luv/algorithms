#include <stdio.h>
//�ϳ���ž

int power(int n) { //Ƚ�� ���
	int i, res = 1;
	for (i = 1; i <= n; i++) {
		res *= 2;
	}
	return res - 1;
}

int hanoi(int from, int other, int to, int n) { //����, ����, ��ǥ, ���� ����
	if (n == 1) {
		printf("%d %d\n", from, to); //������ 1���� �ٷ� ��ǥ������� �ű�
	}
	else {
		hanoi(from, to, other, n - 1); //������ ������ �����ϰ� �������� ���� ������� �ű�
		printf("%d %d\n", from, to); //������ ���� ��ǥ ������� �ű�
		hanoi(other, from, to, n - 1); //������ ������ �����ϰ� �������� ���� ��տ��� ��ǥ ������� �ű�
	}
}

int main() {
	int n;
	scanf_s("%d", &n);
	printf("%d\n", power(n)); //�� ������ Ƚ��
	hanoi(1, 2, 3, n); //�Լ� ȣ��
}