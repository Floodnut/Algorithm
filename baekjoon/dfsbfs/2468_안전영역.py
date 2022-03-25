from copy import deepcopy
from sys import stdin
from itertools import product
from collections import deque
from copy import deepcopy

N = int(stdin.readline())
VX = (0,0,1,-1)
VY = (1,-1,0,0)
CO = list()
light = 0
heavy = 0

areaCnt = 0
areaMax = 1
m = -1

for _ in range(N):
    value = list(map(int, stdin.readline().split()))
    m = max(value)
    CO.append(value)

for rain in range(1, m):
    areaCnt = 0
    G = deepcopy(CO)
    for i, j in product([i for i in range(N)],repeat=2):
        if G[i][j] > rain:
            areaCnt += 1
            dq = deque()
            dq.append((i,j))
            G[i][j] = 0
            while dq:
                area = dq.popleft()
                for k in range(4):
                    x = area[0] + VX[k]
                    y = area[1] + VY[k]
                    if (x >=0 and x < N and y >=0 and y < N) and G[x][y] > rain:
                        G[x][y] = 0
                        dq.append((x,y))
                    else:
                        continue
    if areaMax < areaCnt:
        areaMax = areaCnt

print(areaMax)

