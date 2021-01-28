#include <stdio.h>
#include <stdlib.h>
//상수

char* change(char* num) { //세 자리수 중 첫 번째와 세 번째 수를 서로 바꿈
    char temp;
    temp = num[2];
    num[2] = num[0];
    num[0] = temp;
    return num;
}

int main() {
    char A[4] = { 0, }, B[4] = { 0, }; //배열 초기화
    scanf_s("%s %s", A, 4, B, 4);
    int a = atoi(change(A)); //문자열을 정수로 바꿔주는 함수
    int b = atoi(change(B));

    if (a > b) //더 큰 값을 출력
        printf("%d\n", a);
    else
        printf("%d\n", b);

    return 0;
}