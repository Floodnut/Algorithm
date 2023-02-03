STICK = input()

STACK = []
up, count = 0, 0
for i in range(len(STICK)):
    if STICK[i] =='(' and STICK[i+1] ==')':
        count += up
    elif STICK[i] == '(':
        up += 1
        STACK.append(up)
    elif STICK[i] == ')' and STICK[i-1] != '(':
        count += 1
        up -= 1
        STACK.pop()

print(count)
