#include <stdio.h>

int main(){
	int i, res = 0, height[3];
	
	for (i = 0; i < 3; i ++){
		scanf("%d", &height[i]);
	}
	
	for (i = 0; i < 3; i ++){
		if (height[i] <= 170){
			printf("CRASH %d", height[i]);
			res = 1;
			break;
		}
	}
	if(res == 0)
		printf("PASS");
}
