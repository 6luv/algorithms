#include <stdio.h>
//���� 0

int main() {
	int N, K, count = 0, coin[10] = { 0, }; // �ʱ�ȭ
	scanf_s("%d %d", &N, &K); // ���� n ����, ��ġ�� �� k

	for (int i = 0; i < N; i++) {
		scanf_s("%d", &coin[i]); 
	}

	for (int j = N - 1; j >= 0; j--) { // ū ������ ����
		if (K / coin[j] >= 1) { 
			count += K / coin[j]; 
			K = K % coin[j];
		}
		else
			continue;
	}
	printf("%d", count);
}