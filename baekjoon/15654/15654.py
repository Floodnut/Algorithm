from sys import stdin

n, m = map(int, stdin.readline().split())
nNum = sorted(list(map(int,stdin.readline().split())))

isV = [False] * 8
permu = []

def backtracking(index, n, m):
    if index == m:
        print(' '.join(map(str, permu)))

    for i in range(n):
        if isV[i]: continue
        isV[i] = True
        permu.append(nNum[i])
        backtracking(index+1, n, m)
        isV[i] = False
        permu.pop()

backtracking(0, n, m)