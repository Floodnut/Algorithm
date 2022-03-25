from collections import deque

N = int(input())

G = []
used = []
answer = []
for i in range(N):
    G.append(list(map(int,input())))
    for j in G[i]:
        if G[i][j] == 1:
            used.append((i, j))

w = len(G[0])
h = len(G)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(h):
    for j in range(w):
        if G[i][j] == 1:
            count = 1
            x = i
            y = j
            G[x][y] = 0
            q = deque()
            q.append((i,j))
            while q:
                v = q.popleft()
                for k in range(4):
                    x = v[0] + dx[k]
                    y = v[1] + dy[k]
                    if (x >= 0 and x < h and y >= 0 and y < w) and G[x][y]==1:
                        G[x][y] = 0
                        q.append((x,y))
                        count += 1
                    else:
                        continue
            answer.append(count)

print(len(answer))
answer.sort()
for i in answer:
    print(i)