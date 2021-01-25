#include <stdio.h>

int main() {
	unsigned int a, b, c, count = 1; //a : 고정비용, b : 가변비용, c : 판매비용
	unsigned int bs = 0, cs = 0;
	scanf_s("%d %d %d", &a, &b, &c);
	if (b > c) {
		printf("%d", -1);
	}
	else {
		while (a + b > c) {
			if (a + b + bs >= c + cs) {
				bs += b;
				cs += c;
				count += 1;
			}
			else {
				printf("%d", count);
				break;
			}
		}
	}
}