#include <stdio.h>

int main(int argc, const char * argv[]) {
    int n, tmp, sum = 0;
    scanf("%d", &n);
    for (int i = 1; i < n; i ++) {
        tmp = i;
        sum = i;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        if (sum == n) {
            printf("%d", i);
            n = 0;
            break;
        }
    }
    if (n != 0) {
        printf("0");
    }
    return 0;
}
