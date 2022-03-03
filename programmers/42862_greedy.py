from sys import stdin

def solution(n, lost, reserve):
    answer = 0

    students = [1 for _ in range(n)]

    for i in lost: students[i-1] -= 1
    for i in reserve: students[i-1] += 1

    for i in range(n):
        if students[i] == 0:
            if i == 0:
                if students[i+1] == 2:
                    students[i] += 1
                    students[i+1] -= 1
            elif i + 1 < n:
                if students[i-1] == 2:
                    students[i] += 1
                    students[i-1] -= 1
                elif students[i+1] == 2:
                    students[i] += 1
                    students[i+1] -= 1
            elif i + 1 == n:
                if students[i-1] == 2:
                    students[i] += 1
                    students[i-1] -= 1
                    
    for i in students:
        if i != 0:
            answer += 1

    return answer


a = 5
aa = [2, 4]
aaa = [1, 3, 5]
b = 5
bb = [2, 4]
bbb = [3]
c = 3
cc = [3]
ccc = [1]
d = 5
dd = [2,3,4,5]
ddd = [1]

print("==========")
print("[+] " + str(solution(d, dd, ddd)))