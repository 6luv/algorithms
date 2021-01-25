#include <stdio.h>
//블랙잭

int black(int n, int m) { 
	int num[100] = { 0 , }; //배열 초기화
	int i, j, k, max = 0, sum = 0; //변수 초기화
	for (i = 0; i < n; i++) { 
		scanf_s("%d", &num[i]); //n만큼 숫자 입력받음
	}
	for (i = 0; i < n - 2; i++) { //입력 받은 정수 -2 까지 반복
		for (j = i + 1; j < n - 1; j++) { //입력 받은 정수 -1 까지 반복  
			for (k = j + 1; k < n; k++) {
				sum = num[i] + num[j] + num[k]; //세 수의 합 구함
				if (max < sum && sum <= m) { //최댓값과 같거나 max보다 크면 저장
					max = sum;
				}
			}
		}
	}
	return max;
}

int main() {
	int n, m;
	scanf_s("%d %d", &n, &m);
	printf("%d", black(n, m));
	
	return 0;
}