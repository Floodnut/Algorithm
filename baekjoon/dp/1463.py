from sys import stdin

def solution(n):
    i = 0
    memo = [[n]] 

    while True:
        if 1 in memo[i]:
            return i

        memo.append([])
        for j in range(len(memo[i])):
            if memo[i][j] % 3 == 0:
                memo[i+1].append(memo[i][j] // 3)
            if memo[i][j] % 2 == 0:
                memo[i+1].append(memo[i][j] // 2)
            if memo[i][j] - 1 > 0:
                memo[i+1].append(memo[i][j] - 1)
        i += 1


N = int(stdin.readline())
print(solution(N))