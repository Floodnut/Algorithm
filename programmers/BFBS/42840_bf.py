#complete
from collections import deque

def solution(answers):
    answer = []
    count = [0, 0, 0]
    one = deque([1, 2, 3, 4, 5])
    two = deque([2, 1, 2, 3, 2, 4, 2, 5])
    three = deque([3, 3, 1, 1, 2, 2, 4, 4, 5, 5])

    for i in answers:
        if i == one[0]:
            count[0] += 1
        if i == two[0]:
            count[1] += 1
        if i == three[0]:
            count[2] += 1

        one.rotate(-1)
        two.rotate(-1)
        three.rotate(-1)

    mx = max(count)
    answer = [i+1 for i in range(3) if count[i] == mx]
        

    return answer


a = [1,2,3,4,5]
b = [1,3,2,4,2]

print("====================")
print("[+] a : " + str(solution(a)))
print("--------------------")
print("[+] b : " + str(solution(b)))