from sys import stdin

N, S = map(int, stdin.readline().split())
seq = [0] + list(map(int, stdin.readline().split()))

s, e = 0, 0
prefix = 0
answer = float('inf')

while s < N:
    if s < e and (prefix >= S or e == N):
        s += 1
        prefix -= seq[s]
    else:
        e += 1
        prefix += seq[e]

    if prefix >= S:
        answer = min(answer, e-s)

print(answer if answer != float('inf') else 0)