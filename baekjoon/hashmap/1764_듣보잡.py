#   1764 - 듣보잡
from collections import defaultdict
from sys import stdin

N, M = map(int, stdin.readline().split())
NM = defaultdict(int)
NMlist = []
for _ in range(N+M):
    name = stdin.readline().strip()
    NM[name] += 1
    if NM[name] > 1: 
        NMlist.append(name)
        NMlist.sort()

print(len(NMlist))
for i in NMlist:
    print(i)