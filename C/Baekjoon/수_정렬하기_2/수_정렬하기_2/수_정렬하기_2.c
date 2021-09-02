#include <stdio.h>
#include <stdlib.h>

int compare(const void* num1, const void* num2)
{
	return (*(int*)num1 - *(int*)num2);
}

int main()
{
	int n;

	scanf_s("%d", &n);

	int* num = (int)malloc(sizeof(int) * n);

	for (int i = 0; i < n; i++)
		scanf_s("%d", &num[i]);


	qsort(num, n, sizeof(int), compare);

	for (int j = 0; j < n; j++)
		printf("%d\n", num[j]);

	return 0;
}