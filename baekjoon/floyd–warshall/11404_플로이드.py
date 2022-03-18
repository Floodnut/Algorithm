from sys import stdin
from itertools import product as core

n = int(stdin.readline())
m = int(stdin.readline())

G = [[float('inf')] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, stdin.readline().split())
    G[a][b] = min(G[a][b], c)

node = [i for i in range(1, n+1)]

for k, i, j in core(node, repeat=3):
    if i == j:
        G[i][j] == 0
    else:
        G[i][j] = min(G[i][j], G[i][k] + G[k][j])

for i in range(1, n+1):
    for j in range(1, n+1):
        if G[i][j] == float('inf'):
            print('0', end = " ")
        else:
            print(str(G[i][j]), end=" ")
    print()