from sys import stdin

def solution(n):
    memo = [1,2,4] + [0] * 8
    answer = 0
    
    if n <= 3 :
        answer += memo[n-1]
    else:
        for i in range(3, n):
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3]
        answer += memo[n-1]

    return answer

T = int(stdin.readline())
for _ in range(T):
    n = int( stdin.readline())
    print(solution(n))