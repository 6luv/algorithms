n = int(input())
arr = []
count_1 = 0 
count_2 = 0

for i in range(n):
    arr = input()
    for j in arr:
        if (count_1 >= count_2):
            if (j == '('):
                count_1 += 1
            elif (j == ')'):
                count_2 += 1
        else:
            break
                
    if (count_1 == count_2):
        print("YES")
    else:
        print("NO")
    count_1 = 0
    count_2 = 0
