#include <stdio.h>

int main(){
	int n, i, num;
	scanf("%d", &n);
	if (n == 1)
	{
		scanf("%d", &num);
		printf("%d %d ", num, num);
	}
	for (i = 1; i <= n; i ++){
		scanf("%d", &num);
		if (i == 1)
			printf("%d ", num);
		else if (i == (n + 1) / 2)
			printf("%d ", num);
		else if (i == n)
			printf("%d ", num);
	}
}
