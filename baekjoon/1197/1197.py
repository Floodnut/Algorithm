from sys import stdin

v, e =  list(map(int, stdin.readline().split())) #정점, 간선 의 개수

weight, treeSet = list(), [i for i in range(v+1)]
sum = 0

for i in range(e):
    a, b, c = list(map(int, stdin.readline().split()))
    weight.append(tuple((a,b,c)))

#def makeSet(x): treeSet[x] = x

def find(x):
    if x != treeSet[x]:
        treeSet[x] = find(treeSet[x])
    return treeSet[x]

def union(x, y):
    q = find(x)
    u = find(y)
    if q > u:
        treeSet[u] = q
    else:
        treeSet[q] = u

weight.sort(key=lambda x : x[2])

for a, b, c in weight:
    if find(a) != find(b):
        union(a, b)
        sum += c

print(sum)