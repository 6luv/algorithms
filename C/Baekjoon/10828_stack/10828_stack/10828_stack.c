#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//스택 만들기
#define MAX_SIZE 500002
int stack[MAX_SIZE];
int top = -1;
int count = 0;

//스택에 값 넣기
void push(int x) {
	//top을 1증가시킨 자리에 값 넣기
	top += 1; 
	stack[top] = x;
	count += 1;
}

//스택에 있는 값 출력
void pop(void) {
	//스택에 들어있는 정수가 없을 때
	if (top < 0) {
		printf("-1\n");
	}
	//스택에 정수가 있으면 출력하고 top 1 감소
	else {
		printf("%d\n", stack[top]);
		top -= 1;
		count -= 1;
	}
}

//스택에 들어있는 정수의 개수 출력
void size(void) {
	printf("%d\n", count);
}

//스택이 비었는지 확인
void empty(void) {
	if (top >= 0)	//스택이 비어있지 않음
		printf("0\n");
	else			//스택이 비어있음
		printf("1\n");
}

int main() {
	int n, x;
	char order[10];
	scanf_s("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf_s("%s", order, sizeof(order));
		if (!strcmp(order, "push")) {
			scanf_s("%d", &x);
			push(x);
		}
		else if (!strcmp(order, "pop")) {
			pop();
		}
		else if (!strcmp(order, "size")) {
			size();
		}
		else if (!strcmp(order, "empty")) {
			empty();
		}
		else
			printf("%d\n", top);
	}
}