#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	int number, i, mid, flag;
	int arr[5] = { 0, };

	while(1)
	{
		scanf_s("%d", &number);
		if (number == 0)
			break;
		i = 0;
		while (number != 0)
		{
			arr[i++] = number % 10;
			number = number / 10;
		}
		for (int j = 0; j < i; j++)
		{
			if (arr[j] != arr[i - j - 1])
			{
				flag = 1;
				break;
			}
			else
				flag = 0;
		}
		if (flag == 1)
			printf("no\n");
		else
			printf("yes\n");
	}
	return 0;
}