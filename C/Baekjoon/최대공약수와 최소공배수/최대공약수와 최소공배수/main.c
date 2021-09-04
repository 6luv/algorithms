//
//  main.c
//  최대공약수와 최소공배수
//
//  Created by 장민주 on 2021/08/04.
//

#include <stdio.h>
#include <stdlib.h>
#define MAX(a,b) (((a)>(b))?(a):(b))
#define MIN(a,b) (((a)<(b))?(a):(b))

int GCD(int a, int b) //최대공약수 (유클리드 호제법)
{
    if (a == b)
        return a;
    return GCD(MAX(a, b) - MIN(a, b), MIN(a, b));
}

int main() {
    int a, b, gcd, lcm;
    
    scanf("%d %d", &a, &b);
    
    gcd = GCD(MAX(a, b), MIN(a, b));
    lcm = gcd * (a / gcd) * (b / gcd);
    
    printf("%d\n%d\n", gcd, lcm);
    return 0;
}
