#include <stdio.h>

int main(){
	int i, n[10], p = 0;
	
	for (i = 0; i < 10; i ++){
		scanf("%d", &n[i]);
	}
	for (i = 0; i < 10; i ++){
		if (n[i] % 5 == 0){
			printf("%d", n[i]);
			p = 1;
			break;
		}
	}
	if (p == 0)
		printf("0");
}
