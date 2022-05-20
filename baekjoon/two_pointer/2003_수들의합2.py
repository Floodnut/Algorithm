from sys import stdin

N, M = map(int,stdin.readline().split())
numbers = [0] + list(map(int,stdin.readline().split()))

s, e = 0, 0
prefix = 0
count = 0

while s < N:
    if s < e and (prefix >= M or e == N):
        s += 1   
        prefix -= numbers[s]
    
    else:
        e += 1
        prefix += numbers[e]

    count += 1 if prefix == M else 0

print(count)