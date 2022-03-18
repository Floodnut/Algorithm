from sys import stdin
import heapq

N = int(stdin.readline())
M = int(stdin.readline())

G = [[] for _ in range(N+1)]

for _ in range(M):
    a, b, c = map(int, stdin.readline().split())
    G[a].append((c, b))

S, E = map(int, stdin.readline().split())

def solution(V, K, e):
    COST = [float('inf')] * (V+1) 
    COST[K] = 0
    Q = []
    heapq.heappush(Q, (0, K))
    
    while Q:
        targetCost, target = heapq.heappop(Q)

        if COST[target] < targetCost:
            continue
        
        for newCost, new in G[target]:
            dist = targetCost + newCost

            if dist < COST[new]:  
                COST[new] = dist
                heapq.heappush(Q, [dist, new])

    print(COST[e])


solution(N, S, E)