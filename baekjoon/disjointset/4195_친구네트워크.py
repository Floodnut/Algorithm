from sys import stdin

parent = {}
rank = {}

def find(a):
    if a != parent[a]:
        parent[a] = find(parent[a])
    return parent[a]

def union(a,b):
    a = find(a)
    b = find(b)

    if a != b:
        parent[a] = b
        rank[b] += rank[a]

n = int(stdin.readline())
for _ in range(n):
    parent = {}
    rank = {}
    m = int(stdin.readline())
    for _ in range(m):
        a, b = map(str, stdin.readline().rstrip().split())
        if a not in parent: 
            parent[a] = a
            rank[a] = 1
        if b not in parent: 
            parent[b] = b
            rank[b] = 1
        union(a, b)
        
        print(rank[find(a)])