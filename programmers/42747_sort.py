def solution(citations):
    answer = 0
    citations.sort(key=lambda x:x, reverse=True)
    n = len(citations)
    ok = []
    for i in range(n):
        h = citations.pop(0)
        ok.append(h)
        if len(citations) > 0:
            if len(ok) >= h and citations[0] <= h:
                answer = h 
                break
        else:
            answer = h
            break
         
    return answer






a = [3, 0, 6, 1, 5]
aa = [3, 0, 6, 1, 5,1,1,1,1,1,1]

print("==========")
print("[+] " + str(solution(a)))