#include <stdio.h>

int main(){
	double hieght, weight, sta, bmi;
	
	scanf("%lf %lf", &hieght, &weight);
	sta = (hieght - 100) * 0.9;
	bmi = (weight - sta) * 100 / sta;
	
	if (bmi <= 10)
		printf("정상");
	else if (bmi <= 20)
		printf("과체중");
	else
		printf("비만"); 
}
