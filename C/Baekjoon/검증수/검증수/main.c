//
//  main.c
//  검증수
//
//  Created by 장민주 on 2021/07/12.
//

#include <stdio.h>
#include <stdlib.h>

int main() {
    int num[6];
    int sum = 0;
    for (int i = 0; i < 5; i ++)
    {
        scanf("%d", &num[i]);
    }
    for (int j = 0; j < 5; j ++)
    {
        sum += num[j] * num[j];
    }
    sum = sum % 10;
    printf("%d\n", sum);
    return 0;
}
