from sys import stdin

C = int(stdin.readline())
N = int(stdin.readline())
G = [[0] * (C + 1) for _ in range(C + 1)]

# DFS 풀이
infect = 0
def dfs(c, v, visited):
    global infect
    if visited[1:].count(1) == c:
        return 

    for i in range(1, c+1):
        if G[v][i] and visited[i] == 0:
            visited[i] = 1
            infect += 1
            dfs(c, i, visited)
        else:
            continue

    return visited

for i in range(N):
    x, y = map(int, stdin.readline().split())
    G[x][y] = G[y][x] = 1

answer = dfs(C, 1, ([0] * (C+1)).count(1)-1)

# Union-Find 풀이
# parent = [i for i in range(C+1)]

# def find(a):
#     if a != parent[a]:
#         parent[a] = find(parent[a])
#     return parent[a]

# def union(a, b):
#     a = find(a)
#     b = find(b)
#     if a == 1 or a < b:
#         parent[b] = a
#     else:
#         parent[a] = b

# for i in range(N):
#     x, y = map(int, stdin.readline().split())
#     union(x, y)

# answer = parent.count(1) - 1


# 출력
print(answer)