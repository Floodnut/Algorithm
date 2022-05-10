import heapq
from collections import deque

def solution(jobs):
    answer = 0

    l = len(jobs)
    dq = deque(sorted(jobs))
    start = dq.popleft()
    w = [(start[1],start[0])]
    hq = []

    while len(w) < l:
        for j in dq:
            if w[-1][1] <= j[0] and j[0] <= w[-1][0]:
                heapq.heappush(hq, (j[1],j[0]))

        if len(hq) > 0:
            w.append(heapq.heappop(hq))
    time = 0
    for o, i in w:
        if i > answer:
            answer += ((i-answer) + o)
        else:
            answer += o
        
        time += (answer - i)
        
    return time // l




a = [[0, 3], [1, 9], [2, 6]]
print("====================\n[+] ", solution(a))