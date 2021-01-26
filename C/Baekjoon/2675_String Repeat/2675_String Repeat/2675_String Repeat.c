#include <stdio.h>
#include <stdlib.h>
//문자열 반복

int main() {
	int T, R, len;
	char S[21];
	scanf_s("%d", &T); //테스트 케이스

	for (int i = 0; i < T; i++) { //테스트 케이스만큼 입력
		scanf_s("%d", &R);
		scanf_s("%s", S, sizeof(S));
		len = strlen(S); //문자열 길이

		for (int j = 0; j < len; j++) { //문자열 길이만큼 반복
			for (int k = 0; k < R; k++) { //반복 횟수만큼 문자 출력
				printf("%c", S[j]);
			}
		}
		printf("\n");
	}
	return 0;
}
