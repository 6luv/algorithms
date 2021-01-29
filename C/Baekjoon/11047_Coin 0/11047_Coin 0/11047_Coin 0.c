#include <stdio.h>
//동전 0

int main() {
	int N, K, count = 0, coin[10] = { 0, }; // 초기화
	scanf_s("%d %d", &N, &K); // 동전 n 종류, 가치의 합 k

	for (int i = 0; i < N; i++) {
		scanf_s("%d", &coin[i]); 
	}

	for (int j = N - 1; j >= 0; j--) { // 큰 수부터 나눔
		if (K / coin[j] >= 1) { 
			count += K / coin[j]; 
			K = K % coin[j];
		}
		else
			continue;
	}
	printf("%d", count);
}