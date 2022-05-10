from collections import deque

def solution(name):
    answer = 0

    start = deque(['A'] * len(name))
    li = deque(name)
    std = 0

    #li.rotate(len(name)//2)

    while True:
        if "".join(start) == name:
            break
        
        start[0] = li[0]
        answer += ord(li[0]) - ord('A')
        
        
    '''
    for i in range(len(li)):
        if li[i] == 'A':
            answer += 1
            continue
        elif li[i] == 'Z':
            answer += 2
            continue
        elif ord(li[i]) > ord('N'):
            answer += ord('Z') - ord(li[i])
            answer += 1
        else:
            answer += ord(li[i]) - ord('A')
            answer += 1
    '''
    
    return answer

a = "JEROEN"	
b = "JAN"

print("====================")
print("[+] a : " + str(solution(a)))
print("--------------------")
print("[+] b : " + str(solution(b)))