#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//ť �����
#define MAX_SIZE 50000
int queue[MAX_SIZE];
int top = -1;							//�� �� ����Ŵ
int bottom = -1;						//�� �� ����Ŵ
int count = 0;   

//ť�� �� �ֱ�
void push(int x) {
	if (top == -1) { 
		top = 0;
	}
	queue[++bottom] = x;				//bottom�� 1 ������Ŵ
	count++;
}

//ť�� �ִ� �� ���
void pop(void){
	if (count == 0) {					//ť�� ����ִ� ������ ���� ��
		printf("-1\n");
	} else {							//���ÿ� ������ ������ ����ϰ� top 1 ����
		printf("%d\n", queue[top++]);	//�� �տ� �ִ� ť ����ϰ� 1 ����
		count--;
	}
}

//ť�� ����ִ� ������ ���� ���
void size(void) {
	printf("%d\n", count);
}

//ť�� ������� Ȯ��
void empty(void) {
	if (count != 0)						//ť�� ������� ����
		printf("0\n");
	else								//ť�� �������
		printf("1\n");
}


void front(void) {						//�� �տ� �ִ� ť ���
	if (count > 0)
		printf("%d\n", queue[top]);		
	else
		printf("-1\n");
}

void back(void) {						//�� �ڿ� �ִ� ť ���
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
		else if (!strcmp(order, "back")) {
			back();
		}
	}
}