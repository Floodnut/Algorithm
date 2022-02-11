'''
def solution(numbers, target):
    answer = 0
    Q = []
    Q.append([numbers[0],0])
    Q.append([numbers[0]*-1,0])

    while Q :
        tmp, idx = Q.pop(0)
        idx+=1
        if idx < len(numbers):
            Q.append([tmp+numbers[idx],idx])
            Q.append([tmp-numbers[idx],idx])
        else :
            if target == tmp : answer+=1
    return answer
'''

count = 0

def dfs(numbers, idx, op, f, target):
    global count
    if len(numbers) == idx: 
        if eval(f) == target:
            count += 1
        return
    else:
        f += op + str(numbers[idx]) # f = '' -> f = +1+1+1+1+1 /f = -1
        dfs(numbers, idx + 1, '+', f, target)
        dfs(numbers, idx + 1, '-', f, target)

def solution(numbers, target):
    global count
    
    dfs(numbers, 0, '+', '', target)
    dfs(numbers, 0, '-', '', target)

    answer = count//2
    return answer


a = [1,1,1,1,1] #5
aa = 3
b = [4, 1, 2, 1] #4
bb = 4

print("==========")
print("[+] " + str(solution(a, aa)))

