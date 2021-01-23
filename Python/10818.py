N = int(input())
a = list(map(int,input().split()))
a.sort() #순서대로 정렬 reverse는 거꾸로 정렬
print(a[0], a[N-1])
