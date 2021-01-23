#include <stdio.h>

int main(){
	int a, b;
	char f;
	
	scanf("%d%c%d", &a, &f, &b);
	
	if (f == '+')
		printf("%d", a + b);
	else if (f == '-')
		printf("%d", a - b);
	else if (f == '*')
		printf("%d", a * b);
	else
		printf("%.2f", (double)a / b);
}
