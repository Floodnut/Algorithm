from collections import defaultdict

def dfs(n, computers, now, idx, order, d):
    for i in range(len(now)):
        if now[i] == 0:
            continue
        elif i == idx and d[i] == 0:
            d[i] = order

        elif d[i] == 0:
            d[i] = order

            dfs(n, computers, computers[i], idx, order, d)

def solution(n, computers):
    answer = 0

    order = 1
    d = defaultdict(int)

    for i in range(n):
        dfs(n, computers, computers[i], i, order + i, d)
    #print(li)
    answer = len(list(set(list(d.values()))))

    return answer


a = 3
aa = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
b = 3
bb = [[1, 1, 0], [1, 1, 1], [0, 1, 1]]

print("==========")
print("[+] " + str(solution(b, bb)))
