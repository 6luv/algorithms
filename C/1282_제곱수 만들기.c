#include <stdio.h>
#include <math.h> //sqrt �Լ� ����ϱ� ���� ���� 

int main(){
	int n, k, t; 
	scanf("%d", &n);	
	t = sqrt(n); //���� ū ������ ���� 
	k = n - t * t; //���� ���� k ���� 
	printf("%d %d", k, t);
}  
