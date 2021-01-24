#include <stdio.h>

int main(){
	int n, i, num, count = 0;
	scanf("%d", &n);
	for (i = 0; i < n; i ++){
		scanf("%d", &num);
		if (num % 2 == 0){
			count += 1;
		}
	}
	printf("%d", count);
}
