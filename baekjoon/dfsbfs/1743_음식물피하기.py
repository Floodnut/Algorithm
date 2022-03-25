#Flood Fill
from sys import stdin
from collections import deque

N, M, K = map(int, stdin.readline().split())

G = [[0] * (M+1) for _ in range(N+1)]

for _ in range(K):
    r, c = map(int, stdin.readline().split())    
    G[r][c] = 1

vx = (0,0,1,-1)
vy = (1,-1,0,0)
size = 0

for i in range(1, N+1):
    for j in range(1, M+1):
        if G[i][j] == 1:
            now = 1
            x = i
            y = j
            G[i][j] = 0
            dq = deque()
            dq.append((i,j))

            while dq:
                co = dq.popleft()
                for k in range(4):
                    x = co[0] + vx[k]
                    y = co[1] + vy[k]
                    if (x < N+1 and x > 0 and y < M+1 and y > 0) and G[x][y] == 1:
                        G[x][y] = 0
                        dq.append((x,y))
                        now += 1
                    else:
                        continue
            if now > size:
                size = now

print(size)