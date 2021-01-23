H = int(input())
M = int(input())
L = int(input())
CO = int(input())
CI = int(input())

if H > M:
    if M > L:
        tmp1 = L
    else:
        tmp1 = M
elif M > L:
    if L > H:
        tmp1 = H
    else:
        tmp1 = L
elif L > H:
    if H > M:
        tmp1 = M
    else:
        tmp1 = H
if CO > CI:
    tmp2 = CI
else:
    tmp2 = CO

res = tmp1 + tmp2 - 50
print(res)
