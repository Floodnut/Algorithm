from sys import stdin



def solution(N, numbers):
    i = 0
    memo = [numbers]
    mx = 0
    mxj = 0
    while True:
        memo.append([])
        for j in range(len(memo[i]) - 1):
            memo[i+1].append(memo[i][j]+memo[i][j+1])
        for j in range(len(memo[i+1])):
            if memo[i+1][j] > mx:
                mx = memo[i+1][j]
                mxj = j
        memo[i][j]
        i += 1

    for i in memo:
        print(i)
    return mx


N = int(stdin.readline())
numbers = list(map(int,stdin.readline().split()))

print(solution(N, numbers))