#include <stdio.h>
//����

int main() {
	int n, i, a = 1, count = 1; //a ù ��, count �� �� �̵��ϴ��� �ʱ�ȭ
	scanf_s("%d", &n);

	for (i = 1; i <= n; i++) {
		if (a >= n) { //�Է��� ������ ���ų� Ŀ���� ����
			break;
		}
		else { 
			a += 6 * i; //���� 6�� ���� i�� ���� ����
			count += 1; //���� ������ �� �� �� �̵�
		}
	}
	printf("%d", count); //Ƚ�� ���
}