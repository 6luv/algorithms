#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int age;
    char name[101];
} INFO;

int compare(const void *a, const void *b)    // 오름차순 비교 함수 구현
{
    int num1 = *(int *)a;    // void 포인터를 int 포인터로 변환한 뒤 역참조하여 값을 가져옴
    int num2 = *(int *)b;    // void 포인터를 int 포인터로 변환한 뒤 역참조하여 값을 가져옴

    if (num1 < num2)    // a가 b보다 작을 때는
        return -1;      // -1 반환
    
    if (num1 > num2)    // a가 b보다 클 때는
        return 1;       // 1 반환
    
    else
        return 0;    // a와 b가 같을 때는 0 반환
}

int main() {
    int n; //회원수
    INFO *arr;
    
    arr = (INFO *)malloc(sizeof(INFO) * n);
    
    scanf("%d", &n);
    
    for(int i=0; i<n; i++)
    {
        scanf("%d %s", &arr[i].age, arr[i].name);
    }
    
    qsort(arr, n, sizeof(arr[0]), compare);
    
    for(int j = 0; j < n; j++)
        printf("%d %s\n", arr[j].age, arr[j].name);
    return 0;
}
