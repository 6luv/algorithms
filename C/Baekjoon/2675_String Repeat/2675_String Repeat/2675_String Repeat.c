#include <stdio.h>
#include <stdlib.h>
//���ڿ� �ݺ�

int main() {
	int T, R, len;
	char S[21];
	scanf_s("%d", &T); //�׽�Ʈ ���̽�

	for (int i = 0; i < T; i++) { //�׽�Ʈ ���̽���ŭ �Է�
		scanf_s("%d", &R);
		scanf_s("%s", S, sizeof(S));
		len = strlen(S); //���ڿ� ����

		for (int j = 0; j < len; j++) { //���ڿ� ���̸�ŭ �ݺ�
			for (int k = 0; k < R; k++) { //�ݺ� Ƚ����ŭ ���� ���
				printf("%c", S[j]);
			}
		}
		printf("\n");
	}
	return 0;
}
