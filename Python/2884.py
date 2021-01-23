h, m = map(int, input().split())

i = m + 15

if i >= 60:
    i = i - 60
else:
    h = h - 1
if h < 0:
    h = 23
elif h > 24:
    h = 0

print(h, i)
