N =int(input())
new = N
cycle = 0
while(1):
    a = new // 10
    b = new % 10
    c = (a + b) % 10 #새로운 수의 일의 자리
    new = b * 10 + c
    cycle = cycle + 1
    if new == N:
        break
print(cycle)
