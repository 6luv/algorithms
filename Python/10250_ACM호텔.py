def acm(height, width, n):
    cur_H = 0
    cur_W = 1
    for j in range(0, n):
        if (cur_H < height):        
            cur_H += 1
        else:
            cur_H = 1
            cur_W += 1
    print("%d%02d" %(cur_H, cur_W))

test = int(input())

for i in range(test):
    height, width, n = map(int, input().split())
    acm(height, width, n)
