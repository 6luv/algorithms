#include <stdio.h>

int main(){
	int n1, n2, sum = 0;
	char c;
	scanf("%d", &n1); //ù ��° ���� 
	sum = n1;
	while(1){ // = ������ ���ѷ��� 
		scanf(" %c", &c); //������ 
		scanf("%d", &n2); //���� 
		switch(c){ //������ ��� 
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
		if (c == '=') // =�� ������ ���� 
			break;
	}
	printf("%d", sum);
}
