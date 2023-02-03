from sys import stdin

N = int(stdin.readline())

nums = list()

def heapify(li, i, n):
    l   = i * 2
    r   = i * 2 + 1
    s   = i

    if( l <= n and li[s] > li[l]):
        s = l
    if( r <= n and li[s] > li[r]):
        s = r
    if s != i :
        li[i],li[s] = li[s],li[i]
        return heapify(li, s, n)
def heap(v):
    n = len(v)
    v = [0] + v

    for i in range(n, 0, -1):
        heapify(v, i, n)
    for i in range(n, 0, -1):
        print(v[1])
        v[i], v[1] = v[1], v[i]
        heapify(v, 1, i-1)

for i in range(N):
    nums.append(int(stdin.readline()))
    
heap(nums)
