#include <stdio.h>

int main(){
	int n1, n2, sum = 0;
	char c;
	scanf("%d", &n1); //첫 번째 정수 
	sum = n1;
	while(1){ // = 전까지 무한루프 
		scanf(" %c", &c); //연산자 
		scanf("%d", &n2); //정수 
		switch(c){ //연산자 계산 
			case '+':
				sum += n2;
				break;
			case '-':
				sum -= n2;
				break;
			case '*':
				sum *= n2;
				break;
			case '/':
				sum /= n2;
				break;
		}
		if (c == '=') // =가 나오면 종료 
			break;
	}
	printf("%d", sum);
}
