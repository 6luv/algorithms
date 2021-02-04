#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//���� �����
#define MAX_SIZE 500002
int stack[MAX_SIZE];
int top = -1;
int count = 0;

//���ÿ� �� �ֱ�
void push(int x) {
	//top�� 1������Ų �ڸ��� �� �ֱ�
	top += 1; 
	stack[top] = x;
	count += 1;
}

//���ÿ� �ִ� �� ���
void pop(void) {
	//���ÿ� ����ִ� ������ ���� ��
	if (top < 0) {
		printf("-1\n");
	}
	//���ÿ� ������ ������ ����ϰ� top 1 ����
	else {
		printf("%d\n", stack[top]);
		top -= 1;
		count -= 1;
	}
}

//���ÿ� ����ִ� ������ ���� ���
void size(void) {
	printf("%d\n", count);
}

//������ ������� Ȯ��
void empty(void) {
	if (top >= 0)	//������ ������� ����
		printf("0\n");
	else			//������ �������
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