#include <stdio.h>

int main(){
	int n, i, r, sum = 0;
	scanf("%d", &n);
	
	for (i = 0; i < n; i ++){
		scanf("%d", &r);
		sum += r;
	}
	printf("%d", sum);
	return 0;
}
