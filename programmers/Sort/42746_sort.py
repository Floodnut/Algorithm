def solution(numbers):
    answer = ''

    for i in range(len(numbers)):
        numbers[i] = str(numbers[i])

    answer = "".join(sorted(numbers, key = lambda x: x * 3, reverse=True))

    if answer.count("0") == len(answer): 
        answer = "0"
        
    return answer


a = [6, 10, 2]
aa = [3, 30, 34, 5, 9]



print("==========")
print("[+] " + str(solution(aa)))