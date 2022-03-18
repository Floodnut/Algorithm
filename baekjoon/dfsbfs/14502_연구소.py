from sys import stdin
from collections import deque
from itertools import combinations
import copy

N, M = map(int, stdin.readline().split())

safe = []
virus = []
lab = []

for i in range(N):
    lab.append(list(map(int, stdin.readline().split())))
    for j in range(M):
        if lab[i][j] == 0:
            safe.append((i, j))
        elif lab[i][j] == 2:
            virus.append((i, j))


def infect():
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    g = copy.deepcopy(lab)
    q = deque(virus)
    
    while q:
        v = q.popleft()
        for i in range(4):
            nx = v[0] + dx[i]
            ny = v[1] + dy[i]

            if nx >= 0 and ny >= 0 and nx < N and ny < M: 
                if g[nx][ny] == 0:
                    g[nx][ny] = 2
                    q.append((nx, ny))

    s = 0
    for i in range(N):
        s += g[i].count(0)

    return s

def wall():
    m = 0
    for w in combinations(safe, 3):
        lab[w[0][0]][w[0][1]] = 1
        lab[w[1][0]][w[1][1]] = 1
        lab[w[2][0]][w[2][1]] = 1

        m = max(infect(), m)

        lab[w[0][0]][w[0][1]] = 0
        lab[w[1][0]][w[1][1]] = 0
        lab[w[2][0]][w[2][1]] = 0

    return m

print(wall())