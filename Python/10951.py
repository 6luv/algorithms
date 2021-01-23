while(1):
    try: #에러가 일어날 가능성이 있음
        a, b = map(int, input().split())
        print(a+b)
    except: #에러가 일어났을 때 할 일
        break
