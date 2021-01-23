# 설탕 배달

n = int(input()) # n킬로그램

while(1):
    r = n % 5
    m = n / 5
    if r >= 3:
        k = r % 3
        l = r / 3
    else:
        break
print(m, l)
