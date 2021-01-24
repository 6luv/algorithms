#include <stdio.h>

int main(){
	int n, i, num[1000], max = 0;
	scanf("%d", &n);
	for (i = 0; i < n; i ++){
		scanf("%d", &num[i]);
		if (max < num[i])
			max = num[i];
	}
	printf("%d", max);
}
