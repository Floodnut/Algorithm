#   1620 - 나는야 포켓몬 마스터 이다솜
from collections import defaultdict
from sys import stdin

N, M = map(int, stdin.readline().split())

dogam1 = defaultdict(int)
dogam2 = list()

for i in range(1, N + 1):

    name = stdin.readline().strip()
    dogam1[name] = i
    dogam2.append(name)

for _ in range(1, M + 1):
    name = stdin.readline().strip()

    if name.isnumeric():
        print(dogam2[int(name)-1])
    else:
        print(dogam1[name])