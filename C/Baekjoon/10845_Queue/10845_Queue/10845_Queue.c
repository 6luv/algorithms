#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//스택 만들기
#define MAX_SIZE 10001
int stack[MAX_SIZE];
int toop = -1;
int count = 0;
int i = -1;

//스택에 값 넣기
void push(int x) {
	//top을 1증가시킨 자리에 값 넣기
	toop += 1;
	stack[toop] = x;
	count += 1;
}

//스택에 있는 값 출력
void pop(void) {
	//스택에 들어있는 정수가 없을 때
	if (toop < 0) {
		printf("-1\n");
	}
	//스택에 정수가 있으면 출력하고 top 1 감소
	else {
		i += 1;
		printf("%d\n", stack[i]);
		toop -= 1;
		count -= 1;

	}
}

//스택에 들어있는 정수의 개수 출력
void size(void) {
	printf("%d\n", count);
}

//스택이 비었는지 확인
void empty(void) {
	if (toop >= 0)	//스택이 비어있지 않음
		printf("0\n");
	else			//스택이 비어있음
		printf("1\n");
}


void front(void) {
	if (toop >= 0)
		printf("%d\n", stack[0]);
	else
		printf("-1\n");
}

void back(void) {
	if (toop >= 0)
		printf("%d\n", stack[toop]);
	else
		printf("-1\n");
}

int main() {
	int n, x;
	char order[10];
	scanf_s("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf_s("%s", order, sizeof(order));
		if (!strcmp(order, "push")) { //strcmp는 참이면 0반환, 부정이기 때문에 1반한하여 실행
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
		else if (!strcmp(order, "front")) {
			front();
		}
		else {
			back();
		}

	}
}