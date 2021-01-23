#include <stdio.h>

int main(){
	int n, i, r, num = 0;
	scanf("%d", &n);
	
	for (i = 0; i < n; i ++){
		scanf("%d", &r);
		if (r % 5 == 0){
			num += r;
		}
	}
	printf("%d", num);
}
