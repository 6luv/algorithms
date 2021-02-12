SUM = 0
n = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort(reverse=True)
B.sort()

for i in range(n):
    SUM += A[i] * B[i] 

print(SUM)