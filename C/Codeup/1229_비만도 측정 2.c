#include <stdio.h>

int main(){
	double height, weight, sta, bmi;
	
	scanf("%lf %lf", &height, &weight);
	
	if (height < 150)
		sta = height - 100;
	else if (height < 160)
		sta = (height - 150) / 2 + 50;
	else
		sta = (height - 100) * 0.9;
	
	bmi = (weight - sta) * 100 / sta;
	
	if (bmi <= 10)
		printf("정상");
	else if (bmi <= 20)
		printf("과체중");
	else 
		printf("비만");
}
