def solution(array, commands):
    answer = []
    
    for c in commands:
        k = array[c[0]-1:c[1]]
        answer.append(sorted(k, key = lambda x: x)[c[2]-1])

    return answer


a = [1, 5, 2, 6, 3, 7, 4]
aa = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]



print("==========")
print("[+] " + str(solution(a, aa)))