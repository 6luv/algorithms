//
//  main.c
//  직각삼각형
//
//  Created by 장민주 on 2021/07/12.
//

#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return(*(int *)a - *(int *)b);
}

int main() {
    int num[3];

    while(1)
    {
        for (int i = 0; i < 3; i ++)
            scanf("%d", &num[i]);
        
        if (num[0] == 0 && num[1] == 0 && num[2] == 0)
            break;
        
        qsort(num, 3, sizeof(int), compare);
        
        for (int j = 0; j < 3; j ++)
            num[j] *= num[j];
        
        if (num[0] + num[1] == num[2])
            printf("right\n");
        else
            printf("wrong\n");
    }
    return 0;
}
