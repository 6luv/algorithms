#include <stdio.h>
//손익분기점 계산

int main() {
	long a, b, c, sum;//a 고정비용, b 가변비용, c 판매비용 bs, cs 추가비용
	scanf("%d %d %d", &a, &b, &c);
	if (c - b <= 0) { //손익분기점이 없으면 -1 반환
		printf("%d", -1);
		return 0;
	}
	else {
		sum = a / (c - b) + 1; //cx - (a + bx) > 0 을 만족해야 됨
		printf("%d", sum);
	}
	return 0;
}
/*	정수 범위가 넘어가니까 되도록 수식으로 풀기
	bs = b; //초기화
	cs = c;
	if (b > c) //손익분기점이 없으면 -1 반환
		printf("%d", -1);
	else {
		for (i = 1; ; i++) {
			if ((a + bs) / cs < 1) { //판매비용이 더 커지는 순간 종료
				printf("%d", i);
				break;
			}
			else { //가변비용과 판매비용 추가
				bs += b;
				cs += c;
			}
		}
	}
	return 0;*/
}