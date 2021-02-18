# word = input()
# word = word.strip()                 #앞, 뒤 공백 제거
# count = 0                           #런타임 에러가 뜸 
                                      #입력에서 100만 자리 문자열이 들어오는데
# for i in range(len(word)):          #시간 복잡도 때문인가? 
#     if(word[i] == ' '):             #왜 런타임 에러가 떴는지 찾아야 됨 
#         count += 1

# if (word[len(word) - 1] != ' '):
#     print(count + 1) 
# else:
#     print(count)

word = input().split()
print(len(word))