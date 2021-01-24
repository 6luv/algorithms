#include <stdio.h>

int main(){
	int n, i, res = 1;
	scanf("%d", &n);
	for (i = n; i > 0; i --){
		res = res * i;
	}
	printf("%d", res);
}
