n = int(input())
count = 0
arr = [[0]* 100 for i in range(100)]    # 2차원 배열 초기화

for i in range(n):                      # 색종이 개수만큼 좌표 입력 받음
    x, y = map(int, input().split())    
    for j in range(x, x+10):            # 색종이 크기가 10이라서 
        for k in range(y, y+10):        # 10 * 10을 1로 초기화
            arr[j][k] = 1

for i in range(100):                    # 100 * 100에서 1인 부분만 count 추가
    for j in range(100):
        if(arr[i][j] == 1):
            count += 1

print(count)                      