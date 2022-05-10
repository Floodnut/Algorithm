#complete
from collections import deque

def solution(people, limit):
    answer = 0
    dq = deque(sorted(people, reverse=False))
    while dq:
        if dq[0] + dq[-1] <= limit:
            dq.popleft()
        if len(dq) > 0:
            dq.pop()
        answer += 1
    return answer

a = [70, 50, 80, 50]
aa = 100
b = [70, 80, 50]
bb = 100

print("====================")
print("[+] a : " + str(solution(a, aa)))
print("--------------------")
print("[+] b : " + str(solution(b, bb)))