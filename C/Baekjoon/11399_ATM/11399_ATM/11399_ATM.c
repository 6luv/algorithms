#include <stdio.h>
//ATM

int main() {
	int temp, n, wait = 0, result = 0; // �ʱ�ȭ
	int time[1000] = { 0, }; // �ʱ�ȭ
	scanf_s("%d", &n); // n�� �Է�
	
	for (int i = 0; i < n; i++) { // �ɸ��� �ð� �Է�
		scanf_s("%d", &time[i]);
	}

	for (int i = 0; i < n - 1; i++) { // �������� ����
		for (int j = i + 1; j < n; j++) {
			if (time[i] > time[j]) {
				temp = time[i];
				time[i] = time[j];
				time[j] = temp;
			}
		}
	}
	for (int i = 0; i < n; i++) { // �� ����
		wait += time[i]; 
		result += wait; 
	}
	printf("%d", result); 
}