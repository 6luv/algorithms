#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//���� �����
#define MAX_SIZE 10001
int stack[MAX_SIZE];
int toop = -1;
int count = 0;
int i = -1;

//���ÿ� �� �ֱ�
void push(int x) {
	//top�� 1������Ų �ڸ��� �� �ֱ�
	toop += 1;
	stack[toop] = x;
	count += 1;
}

//���ÿ� �ִ� �� ���
void pop(void) {
	//���ÿ� ����ִ� ������ ���� ��
	if (toop < 0) {
		printf("-1\n");
	}
	//���ÿ� ������ ������ ����ϰ� top 1 ����
	else {
		i += 1;
		printf("%d\n", stack[i]);
		toop -= 1;
		count -= 1;

	}
}

//���ÿ� ����ִ� ������ ���� ���
void size(void) {
	printf("%d\n", count);
}

//������ ������� Ȯ��
void empty(void) {
	if (toop >= 0)	//������ ������� ����
		printf("0\n");
	else			//������ �������
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
		if (!strcmp(order, "push")) { //strcmp�� ���̸� 0��ȯ, �����̱� ������ 1�����Ͽ� ����
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