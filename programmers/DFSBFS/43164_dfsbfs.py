from collections import defaultdict

def solution(tickets):
    answer = []
    stack = ["ICN"]
    path = defaultdict(list)

    for i in tickets:
        path[i[0]].append(i[1])
        path[i[0]].sort(reverse=True)
    
    while stack:
        s = stack[-1]
        print(answer, stack, dict(path))
        if not path[s]:
            answer.append(stack.pop())
        else:
            stack.append(path[s].pop())
    answer.reverse()

    return answer

a = [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
b = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]

print("====================")
print("[+] a : " + str(solution(a)))
print("====================")
print("[+] b : " + str(solution(b)))