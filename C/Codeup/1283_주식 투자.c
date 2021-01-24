#include <stdio.h>

int main(){
	int i, a, b, c; //a : 투자한 액수, b : 투자 일 수 c : 일별 변동 폭 
	double ng, res; //ng : 순수익, res : 
	scanf("%d", &a);
	scanf("%d", &b);
	res = a;
	for (i = 0; i < b; i ++){
		scanf("%d", &c); 
		res = res + res * (double)c/100; //총수익 
	} 
	ng = res - a; //순수익 = 총수익 - 총비용
	if (-0.5 < ng && ng < 0.5) 
		printf("0\n"); 
	else 
		printf("%.0f\n", ng); //반올림하여 순수익 출력 
		
	if (0 < ng)
		printf("good");
	else if (ng == 0)
		printf("same");
	else
		printf("bad");
} 
