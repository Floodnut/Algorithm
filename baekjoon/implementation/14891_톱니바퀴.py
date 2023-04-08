from sys import stdin
from collections import deque

def input():
    return stdin.readline()

gear = []
gear.append(deque(list(stdin.readline().strip()))) # N극은 0
gear.append(deque(list(stdin.readline().strip())))
gear.append(deque(list(stdin.readline().strip())))
gear.append(deque(list(stdin.readline().strip())))

K = int(stdin.readline().strip()) # 회전 수


def turnRight(dq: deque):
    dq.appendleft(dq.pop())
    return dq

def turnLeft(dq: deque):
    dq.append(dq.popleft())
    return dq

for _ in range(K):
    turn = [0, 0, 0, 0]
    a, b = map(int, stdin.readline().split())
    g = a - 1

    turn[g] = b

    ng = g # 기준 기어
    gd = b # 기준 기어 회전 방향
    lg = g - 1 # 비교할 왼쪽 기어
    while(0 <= lg):
        if(gear[ng][6] != gear[lg][2]): # 기준 기어와 왼쪽 기어의 극이 다르다면
            turn[lg] = turn[ng] * -1 # 기준기어와 반대방향으로 돈다.

        lg -= 1
        ng -= 1

    ng = g # 기준 기어
    gd = b # 기준 기어 회전 방향
    rg = g + 1 # 비교할 오른쪽 기어
    while(rg < 4):
        if(gear[ng][2] != gear[rg][6]): # 기준 기어와 왼쪽 기어의 극이 다르다면
            turn[rg] = turn[ng] * -1 # 기준기어와 반대방향으로 돈다.

        rg += 1
        ng += 1
    
    #1, 0 , -1 -> 시계방향, 정지, 반 시계

    for d in range(len(turn)):
        if(turn[d] == 1): # 시계 방향
            turnRight(gear[d])
        elif(turn[d] == -1):  # 반 시계 방향   
            turnLeft(gear[d])

w = 1
answer = 0
for s in gear:
    answer += int(s[0]) * w
    w *= 2

print(answer)