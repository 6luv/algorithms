#include <stdio.h>

int main(){
	int a, b, res = 0, i;
	scanf("%d %d", &a, &b);
	for (i = a; i <= b; i ++){
		if (i % 2 == 0){
			res = res - i;
			printf("-%d", i);
		}
		else {
			res = res + i;
			printf("+%d", i);
		}
	}
	printf("=%d", res);
}
