#include <stdio.h>
//����

int black(int n, int m) { 
	int num[100] = { 0 , }; //�迭 �ʱ�ȭ
	int i, j, k, max = 0, sum = 0; //���� �ʱ�ȭ
	for (i = 0; i < n; i++) { 
		scanf_s("%d", &num[i]); //n��ŭ ���� �Է¹���
	}
	for (i = 0; i < n - 2; i++) { //�Է� ���� ���� -2 ���� �ݺ�
		for (j = i + 1; j < n - 1; j++) { //�Է� ���� ���� -1 ���� �ݺ�  
			for (k = j + 1; k < n; k++) {
				sum = num[i] + num[j] + num[k]; //�� ���� �� ����
				if (max < sum && sum <= m) { //�ִ񰪰� ���ų� max���� ũ�� ����
					max = sum;
				}
			}
		}
	}
	return max;
}

int main() {
	int n, m;
	scanf_s("%d %d", &n, &m);
	printf("%d", black(n, m));
	
	return 0;
}