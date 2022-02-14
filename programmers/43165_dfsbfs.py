count = 0

def dfs(numbers, idx, op, result, target):
    global count
    if len(numbers) == idx: 
        if result == target:
            count += 1
        return
    else:
        if op == "+":
            result += numbers[idx]
        elif op == "-":
            result -= numbers[idx]

        dfs(numbers, idx + 1, '+', result, target)
        dfs(numbers, idx + 1, '-', result, target)

def solution(numbers, target):
    global count
    
    dfs(numbers, 0, '+', 0,target)
    dfs(numbers, 0, '-', 0,target)

    answer = count//2
    return answer


a = [1,1,1,1,1] #5
aa = 3
b = [4, 1, 2, 1] #4
bb = 4

print("==========")
print("[+] " + str(solution(a, aa)))

