from itertools import permutations

def solution(expression):
    symbols = ["-", "+", "*"]
    answer = []
    for i in permutations(symbols):
        first, second = i[0], i[1]
        lst = []
        for e in expression.split(first):
            temp = [f"({i})" for i in e.split(second)]
            lst.append(f'({second.join(temp)})')
        answer.append(abs(eval(first.join(lst))))
    return max(answer)



a = "100-200*300-500+20"

print("==========")
print("[+] " + str(solution(a)))
