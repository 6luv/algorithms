#include <stdio.h>
//ATM

int main() {
	int temp, n, wait = 0, result = 0; // 초기화
	int time[1000] = { 0, }; // 초기화
	scanf_s("%d", &n); // n명 입력
	
	for (int i = 0; i < n; i++) { // 걸리는 시간 입력
		scanf_s("%d", &time[i]);
	}

	for (int i = 0; i < n - 1; i++) { // 오름차순 정렬
		for (int j = i + 1; j < n; j++) {
			if (time[i] > time[j]) {
				temp = time[i];
				time[i] = time[j];
				time[j] = temp;
			}
		}
	}
	for (int i = 0; i < n; i++) { // 합 구함
		wait += time[i]; 
		result += wait; 
	}
	printf("%d", result); 
}