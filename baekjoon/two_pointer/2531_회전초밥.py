from sys import stdin
from collections import deque
from itertools import islice

N, d, k, c = map(int, stdin.readline().split())
sushi = deque([int(stdin.readline()) for _ in range(N)])
answer = 0

for rc in range(N):
    menu = set(islice(sushi, 0, k))
    menu.add(c)
    answer = max(answer, len(menu))
    
    sushi.rotate(1)

print(answer)


#####################

from sys import stdin
from collections import defaultdict

N, d, k, c = map(int, stdin.readline().split())
sushi = [int(stdin.readline()) for _ in range(N)] * 2
eat = defaultdict(int)
answer = 0
eat[c] += 1
for i in range(k):
    eat[sushi[i]] += 1

rp = k

while rp < N * 2:
    answer = max(answer, len(eat))

    eat[sushi[rp - k]] -= 1

    if eat[sushi[rp - k]] == 0:
        eat.pop(sushi[rp - k], None)
    eat[sushi[rp]] += 1
    rp += 1 

print(answer)