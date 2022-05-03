
from collections import defaultdict
from sys import stdin

N = int(stdin.readline())

card = defaultdict(int)
result = [0,0]

for i in range(0, N):
    num = int(stdin.readline())
    card[num] += 1

    if (i == 0) or ((result[0] > num) and (result[1] == card[num])) or (result[1] < card[num]):
        result[0] = num
        result[1] = card[num]

print(result[0])