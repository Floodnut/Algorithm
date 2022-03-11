import heapq
from sys import stdin

V, E = map(int, stdin.readline().split())
K = int(stdin.readline())
G = [ [] for _ in range(V+1) ]

for _ in range(E):
    u, v, w = map(int, stdin.readline().split())
    G[u].append((w,v))

def solution(V, K):
    COST = [float('inf')] * (V+1) 
    COST[K] = 0
    Q = []
    heapq.heappush(Q, (0,K))
    
    while Q:
        targetCost, target = heapq.heappop(Q)

        if COST[target] < targetCost:
            continue
        
        for newCost, new in G[target]:
            dist = targetCost + newCost

            if dist < COST[new]:  
                COST[new] = dist
                heapq.heappush(Q, [dist, new])
    
    for i in COST[1:]:
        if i == float('inf'):
            print("INF")
        else:
            print(i)


solution(V, K)