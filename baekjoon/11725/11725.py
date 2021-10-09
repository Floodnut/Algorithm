from collections import deque
from sys import stdin 

n = int(stdin.readline())

l = {node: list() for node in range(n+1)}

for i in range(n-1):
    a, b = list(map(int, stdin.readline().split()))
    l[a].append(b)
    l[b].append(a)
 
bfs = deque([1])
vNode = {i: False for i in range(1, n+1)}
node = {item: {"parent": list(), "child": list()} for item in range(1, n + 1)}

while bfs:
    current = bfs.popleft()
    vNode[current] = True
    for i in l[current]:
        if not vNode[i]:
            node[current]["child"].append(i)
            node[i]["parent"].append(current)
            bfs.append(i)
 
for i in range(2, n+1):
    print(node[i]["parent"][-1])