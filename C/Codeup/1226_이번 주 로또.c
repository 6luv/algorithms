#include <stdio.h>

int main(){
	int i, j, count = 0, bonus = 0, lotto[7], juhi[6];
	
	for (i = 0; i < 7; i ++){
		scanf("%d", &lotto[i]);
	}
	for (i = 0; i < 6; i ++){
		scanf("%d", &juhi[i]);
	}
	for (i = 0; i < 6; i ++){
		for (j = 0; j < 6; j ++){
			if (lotto[i] == juhi[j]){
				count += 1;
			}
		}
	}
	for (i = 0; i < 6; i ++){
		if (lotto[6] == juhi[i]){
			bonus += 1;
		}
	}
	switch(count){
		case 0:
		case 1:
		case 2:
			printf("0");
			break;
		case 3:
			printf("5");
			break;
		case 4:
			printf("4");
			break;
		case 5:
			if (bonus == 1){
				printf("2");
				break;
			}
			else {
				printf("3");
				break;
			}
		case 6:
			printf("1");
			break;
	}
}
