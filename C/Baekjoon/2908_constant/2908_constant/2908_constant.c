#include <stdio.h>
#include <stdlib.h>
//���

char* change(char* num) { //�� �ڸ��� �� ù ��°�� �� ��° ���� ���� �ٲ�
    char temp;
    temp = num[2];
    num[2] = num[0];
    num[0] = temp;
    return num;
}

int main() {
    char A[4] = { 0, }, B[4] = { 0, }; //�迭 �ʱ�ȭ
    scanf_s("%s %s", A, 4, B, 4);
    int a = atoi(change(A)); //���ڿ��� ������ �ٲ��ִ� �Լ�
    int b = atoi(change(B));

    if (a > b) //�� ū ���� ���
        printf("%d\n", a);
    else
        printf("%d\n", b);

    return 0;
}