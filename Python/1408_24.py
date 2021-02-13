cur_H, cur_M, cur_S = map(int, input().split(':'))
sta_H, sta_M, sta_S = map(int, input().split(':'))


if (sta_S - cur_S < 0):
    res_S = sta_S - cur_S + 60
    if (sta_M < 0):
        sta_H -= 1
    else:
        sta_M -= 1   

else:
    res_S = sta_S - cur_S

if (sta_M - cur_M < 0):
    res_M = sta_M - cur_M + 60
    sta_H -= 1
else:
    res_M = sta_M - cur_M

if (sta_H - cur_H < 0):
    res_H = 24 + sta_H - cur_H
else:
    res_H = sta_H - cur_H
    
print("%02d:%02d:%02d" %(res_H, res_M, res_S))



