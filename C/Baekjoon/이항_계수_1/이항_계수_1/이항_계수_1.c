#include <stdio.h>
#include <stdlib.h>

int combination(int n)
{
	if (n == 1)
		return 1;
	else if (n == 0)
		return 1;
	else
		return n * combination(n - 1);
}

int main()
{
	int n, k, res = 0;
	scanf_s("%d %d", &n, &k);

	res = combination(n) / (combination(k) * combination(n - k));
	printf("%d", res);
	return 0;
}