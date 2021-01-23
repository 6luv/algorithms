#include <stdio.h>

int main(){
	int i, d;
	scanf("%d", &d);
	
	for (i = 1; i <= 9; i ++){
		printf("%d*%d=%d\n", d, i, d * i);
	}
} 
