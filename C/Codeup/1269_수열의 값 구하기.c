#include <stdio.h>

int main(){
	int i, a, b, c, n, temp = 0, sum = 0;
	scanf("%d %d %d %d", &a, &b, &c, &n);
	if (n == 1){
		printf("%d", a);
	}
	else{
		temp = a * b + c;
		for (i = 2; i < n; i ++){
			sum = temp * b + c;
			temp = sum;
		}
	printf("%d", sum);
	}

}
