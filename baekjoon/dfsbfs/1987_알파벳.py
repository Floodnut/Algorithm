#----------------------#
# Input, Shared
from sys import stdin

R, C = map(int, stdin.readline().split())
G = [[False] * (1 + C)]

for _ in range(R):
    li = list(stdin.readline().rstrip())
    G.append([False] + li)

dx = (0, 0, 1, -1)
dy = (1, -1, 0, 0)

#----------------------#
# DFS with PyPy3
result = 0
visited = {G[1][1]}

def dfs(i, j, count):
    global result
    result = max(result, count)

    for k in range(4):
        x = i + dx[k]
        y = j + dy[k]

        if R >= x > 0 and C >= y > 0 and G[x][y] not in visited:
            visited.add(G[x][y])
            dfs(x, y, count + 1)
            visited.remove(G[x][y])


dfs(1, 1, 1)
print(result)
#----------------------#
# BFS with SET
dx = (0, 0, 1, -1)
dy = (1, -1, 0, 0)
result = 0

for _ in range(R):
    li = list(stdin.readline().rstrip())
    G.append([False] + li)

visited = { (1, 1, G[1][1]) }

while visited:
    a, b, v = visited.pop()
    result = max(result, len(v))

    for k in range(4):
        x = a + dx[k]
        y = b + dy[k]

        if R >= x > 0 and C >= y > 0 and G[x][y] not in v:
            visited.add((x, y, v + G[x][y]))

print(result)
#----------------------#