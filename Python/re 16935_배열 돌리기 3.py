n, m, r = map(int, input().split())
arr = [list(input().split()) for i in range(n)]
        #[[0]* n for i in range(m)]
num = int(input())

for i in range(r):
    if (num == 1):                          #상하반전
        for j in range(n-1, -1, -1):
            for k in range(0, m):
                print(arr[j][k], end=' ')   
            print()
    elif (num == 2):                        #좌우반전
        for j in range(n):
            for k in range(m - 1, -1, -1):
                print(arr[j][k], end=' ')
            print()
    elif (num == 3):                        #오른쪽으로 90도 회전
        for j in range(m):
            for k in range(n - 1, -1, -1):
                print(arr[k][j], end=' ')
            print()   
    elif (num == 4):                        #왼쪽으로 90도 회전
        for j in range(m - 1, -1, -1):
            for k in range(n):
                print(arr[k][j], end=' ')
            print()        