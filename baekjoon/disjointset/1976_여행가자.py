from sys import stdin

def find(v):
    while v != parent[v]:
        v = parent[v]
    return parent[v]

def union(a,b):
    a = find(a)
    b = find(b)
    if a == b:
        return

    if a < b :
        parent[b] = a
    else:
        parent[a] = b

N = int(stdin.readline())
M = int(stdin.readline())

parent = [i for i in range(N+1)]

for i in range(1, N+1):
    li = list(map(int, stdin.readline().split()))
    for j in range(1, len(li)+1):
        if li[j-1] == 1:
            union(i, j)

P = list(map(int, stdin.readline().split()))
answer = []
for i in P:
    answer.append(find(i))

if 1 == len(set(answer)):
    print("YES")
else:
    print("NO")