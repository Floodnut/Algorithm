from sys import stdin
from collections import deque

for _ in range(int(stdin.readline())):
    M, N, K = map(int, stdin.readline().split())
    G = [[0] * M for _ in range(N)]
    answer = 0
    dx = (0, 0, 1, -1)
    dy = (1, -1, 0, 0)
    dq = deque()

    for _ in range(K):
        x, y = map(int, stdin.readline().split())
        G[y][x] = 1

    for i in range(N):
        for j in range(M):
            if G[i][j] == 1:
                answer += 1
                G[i][j] = 0
                dq.append((i, j))

                while dq:
                    xy = dq.popleft()

                    for k in range(4):
                        x = xy[0] + dx[k] 
                        y = xy[1] + dy[k]

                        if N > x >= 0 and M > y >= 0 and G[x][y] == 1:
                            G[x][y] = 0
                            dq.append((x, y))
                            
    print(answer)

