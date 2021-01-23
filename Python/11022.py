T = int(input())
sum = [];
c = [];
d = [];
for i in range(T):
    a, b = map(int, input().split())
    c.append(a)
    d.append(b)
    sum.append(a + b)
for i in range(T):
    print("Case #%d: %d + %d = %d" %(i+1, c[i], d[i], sum[i]));
