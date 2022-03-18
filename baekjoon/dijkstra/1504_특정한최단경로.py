from sys import (
    stdin,
    maxsize as INF
)
import heapq

N, E = map(int, stdin.readline().split())

G = [[] for _ in range(N+1)]

for _ in range(E):
    a, b, c = map(int, stdin.readline().split())
    G[a].append((c, b))
    G[b].append((c, a))

v1, v2 = map(int, stdin.readline().split())

def dij(V, s, e):
    COST = [INF] * (V+1) 
    COST[s] = 0
    Q = []
    result = []
    heapq.heappush(Q, (0, s))

    while Q:
        targetCost, target = heapq.heappop(Q)

        if COST[target] < targetCost:
            continue
        
        for newCost, new in G[target]:
            dist = targetCost + newCost

            if dist < COST[new]:  
                COST[new] = dist
                heapq.heappush(Q, [dist, new])

    for i in e:
        result.append(COST[i])

    return result


def solution(V, K, e):
    s2v = dij(V, K, [v1, v2])
    v2v = dij(V, v1, [v2])
    e2v = dij(V, e, [v1, v2])

    if (s2v[0] < INF or s2v[1] < INF) and v2v[0] < INF and (e2v[0] < INF or e2v[1] < INF):
        answer = min(s2v[0] + v2v[0] + e2v[1], s2v[1] + v2v[0] + e2v[0])
        print(answer)
        return
    print(-1)

solution(N, 1, N)