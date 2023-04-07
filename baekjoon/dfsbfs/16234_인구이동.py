from sys import stdin
from collections import deque

N = 0
L = 0
R = 0

A = [[0] * (N + 1)]

DX = (0, 0, 1, -1)
DY = (1, -1, 0, 0)

def bfs():
    q = deque()
    day = 0
    flag = True
    while(flag):
        UNION = [[False] * (N + 1) for _ in range(N + 1)]
        flag = False

        for i in range(1, N + 1):
            for j in range(1, N + 1):
                if UNION[i][j] == 0:
                    q.append((i, j))
                    population = A[i][j]
                    UNION[i][j] = True
                    country = [(i, j)]
                    while(q) :
                        x, y = q.popleft()

                        for k in range(4):
                            dx = x + DX[k]
                            dy = y + DY[k]

                            if(dx <= 0 or N < dx or dy <= 0 or N < dy):
                                continue

                            if(UNION[dx][dy]):
                                continue
                            
                            if(L <= abs(A[x][y] - A[dx][dy]) <= R):
                                flag = True
                                UNION[dx][dy] = True
                                q.append((dx, dy))
                                population += A[dx][dy]
                                country.append((dx, dy))

                    if(1 < len(country)):
                        v = population // len(country)  
                        for k in country:
                            A[k[0]][k[1]] = v
        if not flag:
            break

        day += 1

    return day

N, L, R = map(int, stdin.readline().split())

for i in range(1, N + 1):
    A.append([0] + list(map(int, stdin.readline().split())))

print(bfs())