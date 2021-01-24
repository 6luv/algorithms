#include <stdio.h>

void star(int y, int x, int n) {
	if ((y / n) % 3 == 1 && (x / n) % 3 == 1) { //x, y좌표 모두 나머지가 1이면 공백 출력
		printf(" ");
	}
	else {
		if (n / 3 == 0) {
			printf("*");
		}
		else {
			star(y, x, n / 3);
		}
	}
}

int main() {
	int n, i, j;
	scanf_s("%d", &n);
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			star(i, j, n);
		}
		printf("\n");
	}
	printf("%d", (3 / 27) % 3);
}
