from itertools import product as core

N = int(input())
G = []
node = [i for i in range(N)]

for _ in range(N):
    G.append(list(map(int, input().split())))

for k, x, y in core(node, repeat=3):
    if G[x][k] == 1 and G[k][y] == 1:
        G[x][y] = 1

for i in G:
    print(' '.join(map(str, i)))