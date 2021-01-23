#include <stdio.h>

int main(){
	int n, count = 1;
	scanf("%d", &n);
	while(1)
	{
		if (n / 10 == 0)
			break;
		else
			n = n / 10;
			count += 1;
	}
	printf("%d", count);
}
