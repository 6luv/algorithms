#include <stdio.h>

int main(){
	int k, h, ks, hs;
	scanf("%d %d", &k, &h);
	
	if (k % 2 == 0)
		ks = 5 * k;
	else
		ks = (k + 1) / 2;
		
	if (h % 2 == 0)
		hs = 5 * h;
	else
		hs = (h + 1) / 2;
	
	printf("%d", ks + hs);
}
