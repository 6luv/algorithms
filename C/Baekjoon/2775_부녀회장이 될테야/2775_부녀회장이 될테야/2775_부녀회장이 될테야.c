#include <stdio.h>
//�γ�ȸ���� ���׾�

int add(int k, int n) {
	if (k == 0) { //������ 0�̸� ȣ�� n��ŭ ��ȯ
		return n;
	}
	else if (n == 1) { //ȣ���� 1�̸� 1��ȯ
		return 1;
	}
	else { //����Լ� �̿�
		return add(k, n - 1) + add(k - 1, n); 
	}
}

int main() {
	int T, k, n, sum = 0;
	scanf_s("%d", &T); //�׽�Ʈ ���̽�

	for (int i = 0; i < T; i++) { //�׽�Ʈ ���̽���ŭ �ݺ�
		scanf_s("%d", &k); //����
		scanf_s("%d", &n); //ȣ��
		
		sum = add(k, n); //����Լ�
		printf("%d\n", sum); //���ֹ� �� ���
	}
	return 0;
}