def solution(begin, target, words):
    answer = 0
    used = dict()
    for w in words: used[w] = 0
    stack = [begin]
    w = ''

    while stack:
        w = stack.pop()
        if w == target:
            return answer
        else:
            used[w] = 1
            for i in range(len(words)):
                tmp = []
                for j in range(len(words[i])):
                    if words[i][j] != w[j]:
                        tmp.append(words[i][j])
                if len(tmp) == 1 and used[words[i]] == 0:
                    used[words[i]] = 1
                    stack.append(words[i])
            answer += 1
    
    if w != target:
        return 0

    return answer



a = "hit"
aa = "cog"
aaa = ["hot", "dot", "dog", "lot", "log", "cog"]
b = "hit"
bb = "cog"
bbb = ["hot", "dot", "dog", "lot", "log"]


print("==========")
print("[+] " + str(solution(b, bb,bbb)))




