#include <stdio.h>
#include <math.h> //sqrt 함수 사용하기 위해 선언 

int main(){
	int n, k, t; 
	scanf("%d", &n);	
	t = sqrt(n); //가장 큰 제곱근 구함 
	k = n - t * t; //가장 작은 k 구함 
	printf("%d %d", k, t);
}  
