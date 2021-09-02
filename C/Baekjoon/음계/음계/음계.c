#include <stdio.h>
#include <stdlib.h>

int main()
{
	int ascending[8] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	int descending[8] = { 8, 7, 6, 5, 4, 3, 2, 1 };
	int scale[8];
	int flag = 0;

	for (int i = 0; i < 8; i++)
		scanf_s("%d", &scale[i]);

	for (int j = 1; j < 8; j++)
	{
		if (scale[0] == ascending[0])
		{
			if (scale[j] == ascending[j])
				flag = 1;
			else
			{
				flag = 3;
				break;
			}
		}
		else if (scale[0] == descending[0])
		{
			if (scale[j] == descending[j])
				flag = 2;
			else
			{
				flag = 3;
				break;
			}
		}
		else
			flag = 3;
	}

	if (flag == 1)
		printf("ascending\n");
	else if (flag == 2)
		printf("descending\n");
	else
		printf("mixed\n");
	return 0;
}