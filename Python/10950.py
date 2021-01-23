n = []
t = int(input())
for i in range(t):
    a, b = map(int, input().split())
    n.append(a+b)

for i in range(t):
    print(n[i])
