def solution(N, number):
    answer = 0

    i = 0
    memo = [[0]]

    while True:
        if number in memo[i]:
            return i

        memo.append([])

        for j in range(len(memo[i])):
            memo[i+1].append(memo[i][j] + N)
            memo[i+1].append(memo[i][j] - N)
            memo[i+1].append(memo[i][j] * N)
            memo[i+1].append(memo[i][j] // N)
            memo[i+1].append(memo[i][j] + int(str(N) * 2))
            memo[i+1].append(memo[i][j] - int(str(N) * 2))
            memo[i+1].append(memo[i][j] * int(str(N) * 2))
            memo[i+1].append(memo[i][j] // int(str(N) * 2))
        i += 1


    return answer


a = 5
aa = 12
b = 2
bb = 11

print("==========")
print("[+] " + str(solution(a, aa)))