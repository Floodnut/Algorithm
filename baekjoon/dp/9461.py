from sys import stdin

def solution(n):
    P = [1, 1, 1, 2, 2, 3, 4, 5, 7, 9]

    if n < 11:
        return P[n-1]
    else:
        for i in range(10, n):
            P.append(P[i-1] + P[i-5])
        return P[-1]

T = int(stdin.readline())
for i in range(T):
    N = int(stdin.readline())
    print(solution(N))