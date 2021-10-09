from sys import stdin

n = int(stdin.readline())
parent = list(map(int, stdin.readline().split()))
d = int(stdin.readline())
tree = [[] for _ in range(n)]
leafCount = 0

for i in range(0, n):
    if parent[i] != -1:
        tree[parent[i]].append(i)
    else:
        root = i

def dfs(node):
    global leafCount, d

    if len(tree[node]) == 0 : 
        leafCount += 1
        return
    else:
        for i in tree[node]:
            if i == d and len(tree[node]) == 1: 
                leafCount += 1
            elif i == d : 
                continue
            else: 
                dfs(i)

if d == root: 
    print(0)
else:
    dfs(root)
    print(leafCount)