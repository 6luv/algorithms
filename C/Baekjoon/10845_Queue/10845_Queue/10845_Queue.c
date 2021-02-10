#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//큐 만들기
#define MAX_SIZE 50000
int queue[MAX_SIZE];
int top = -1;							//맨 앞 가리킴
int bottom = -1;						//맨 뒤 가리킴
int count = 0;   

//큐에 값 넣기
void push(int x) {
	if (top == -1) { 
		top = 0;
	}
	queue[++bottom] = x;				//bottom을 1 증가시킴
	count++;
}

//큐에 있는 값 출력
void pop(void){
	if (count == 0) {					//큐에 들어있는 정수가 없을 때
		printf("-1\n");
	} else {							//스택에 정수가 있으면 출력하고 top 1 감소
		printf("%d\n", queue[top++]);	//맨 앞에 있는 큐 출력하고 1 증가
		count--;
	}
}

//큐에 들어있는 정수의 개수 출력
void size(void) {
	printf("%d\n", count);
}

//큐가 비었는지 확인
void empty(void) {
	if (count != 0)						//큐가 비어있지 않음
		printf("0\n");
	else								//큐가 비어있음
		printf("1\n");
}


void front(void) {						//맨 앞에 있는 큐 출력
	if (count > 0)
		printf("%d\n", queue[top]);		
	else
		printf("-1\n");
}

void back(void) {						//맨 뒤에 있는 큐 출력
	if (count > 0)
		printf("%d\n", queue[bottom]);
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
		else if (!strcmp(order, "back")) {
			back();
		}
	}
}