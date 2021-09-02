#include <stdio.h>
#include <stdlib.h>

int main()
{
	char word[1000001];
	int cnt[26] = { 0, };
	int len;
	int max = 0, position, flag = 0;

	scanf_s("%s", word, sizeof(word));
	len = strlen(word);

	for (int i = 0; i < len; i++)
	{
		if ('a' <= word[i] && word[i] <= 'z')
			word[i] = word[i] - 32;
	}

	for (int i = 0; i < len; i++)
	{
		cnt[word[i] - 'A']++;
	}

	for (int j = 0; j < 26; j++)
	{
		if (cnt[j] > max)
		{
			max = cnt[j];
			position = j;
			flag = 0;
		}
		else if (cnt[j] == max && max != 0)
		{
			flag = 1;
		}
	}

	if (flag == 1)
		printf("?");
	else
		printf("%c", position + 'A');
	
	return 0;
}