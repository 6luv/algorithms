T = int(input())
sum = [];
for i in range(T):
    a, b = map(int,input().split())
    sum.append(a + b);
for i in range(T):
    print("Case #%d:"%(i+1), sum[i]);
