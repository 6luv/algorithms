#include <stdio.h>

int main(){
	int i, a, b, c; //a : ������ �׼�, b : ���� �� �� c : �Ϻ� ���� �� 
	double ng, res; //ng : ������, res : 
	scanf("%d", &a);
	scanf("%d", &b);
	res = a;
	for (i = 0; i < b; i ++){
		scanf("%d", &c); 
		res = res + res * (double)c/100; //�Ѽ��� 
	} 
	ng = res - a; //������ = �Ѽ��� - �Ѻ��
	if (-0.5 < ng && ng < 0.5) 
		printf("0\n"); 
	else 
		printf("%.0f\n", ng); //�ݿø��Ͽ� ������ ��� 
		
	if (0 < ng)
		printf("good");
	else if (ng == 0)
		printf("same");
	else
		printf("bad");
} 
