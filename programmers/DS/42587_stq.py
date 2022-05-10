from collections import deque

def solution(priorities, location):
    answer = 0
    size = len(priorities)

    for s in range(size):
        priorities[s] = (s, priorities[s])    

    std = sorted(priorities, key = lambda x : (x[1]), reverse=True)
    sq = deque(std)
    dq = deque(priorities)

    while(len(dq)>0):
        if dq[0][1] == sq[0][1]:

            if dq[0][0] == location :
                return answer + 1
            else:
                dq.popleft()
                sq.popleft()
                answer += 1
        else:
            dq.append(dq.popleft())



a = [2, 1, 3, 2]
aa = 2
b = [1, 1, 9, 1, 1, 1]
bb = 0

print("==========")
print("[+] " + str(solution(b, bb)))