from sys import stdin
from collections import deque

N, M, V = map(int, input().split())
G = [[0]* (N+1) for _ in range(N+1)]

for i in range(M):
    g1, g2 = map(int, input().split())
    G[g1][g2] = 1
    G[g2][g1] = 1

dfs_used = [0] * (N + 1)
dfs_stack = []

def dfs(N,M,V,G):
    dfs_used[V] = 1
    dfs_stack.append(V)

    if len(dfs_stack) == N:
        return
    
    for i in range(N+1):
        if dfs_used[i] == 0 and G[i][V]:
            dfs(N,M,i,G)

    return dfs_stack


def bfs(N,M,V,G):
    used = [0] * (N + 1)
    used[V] = 1
    q = deque([V])
    stack = []
    
    while q:
        n = q.popleft()
        stack.append(n)

        for i in range(N+1):
            if used[i] == 0 and G[i][n]:
                q.append(i)
                used[i] = 1
    return stack


for i in dfs(N,M,V,G):
    print(i,end=' ')

print()
for i in bfs(N,M,V,G):
    print(i,end=' ')
print()