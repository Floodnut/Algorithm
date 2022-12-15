from sys import (
    stdin, 
    setrecursionlimit
    )

setrecursionlimit(100000)
parent = []

def uni(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        parent[b] = a
    else :
        parent[a] = b

def find(a):
    if a != parent[a]:
        parent[a] = find(parent[a])
    return parent[a]

def solution():
    global parent
    n, m = map(int, stdin.readline().split())

    parent = [i for i in range(n+1)]

    for _ in range(m):
        op, a, b = map(int, stdin.readline().split())

        if op: # op == 1, 두 원소가 같은 집한에 있는지 확인
            if find(a) == find(b):
                print("YES")
            else:
                print("NO")
        else: # op == 0, 합 집합
            uni(a, b)

solution()