arr = []
for i in range(9):
    arr.append(int(input()))
print(max(arr))
print(arr.index(max(arr))+1) #max값의 인덱스를 돌려줌
