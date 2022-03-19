from sys import stdin
from collections import deque
#deque rotate
n = int(input())
idx = 0
result = []

data = list(map(int, stdin.readline().split()))
index = [x for x in range(1, n + 1)]

temp = data.pop(idx)
result.append(index.pop(idx))

while data:
    if temp < 0:
        idx = (idx + temp) % len(data)
    else:
        idx = (idx + (temp - 1)) % len(data)
    temp = data.pop(idx)
    result.append(index.pop(idx))

for r in result:
    print(r, end=' ')


'''
class Balloon:
    def __init__(self, num=0, left=0, right=0, used=False):
        self.num = num
        self.left = left
        self.right = right
        self.used = used

N = int(stdin.readline())
balloon = list(map(int,stdin.readline().strip().split()))
bd = defaultdict(Balloon)
used = []
move = 0
b = 0
now = bd[0]

for i in range(N):
    bd[i].num = i
    if i == 0:
        bd[i].left = bd[N-1]
        bd[i].right = bd[1]
    elif i == N-1:
        bd[i].left = bd[i-1]
        bd[i].right = bd[0]
    else:    
        bd[i].left = bd[i-1]
        bd[i].right = bd[i+1]

while(len(used) != N):
    mCnt = 0
    move = balloon[b]

    if b >= N:
        b -= N
    elif b < 0:
        b += N
    
    if move > 0:
        while (mCnt != move):
            now = 
    else:
        while(mCnt != abs(move)):
'''