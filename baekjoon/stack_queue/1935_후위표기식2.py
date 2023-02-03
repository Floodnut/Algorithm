import sys

num = []

class Stack:
    def __init__(self):
        self.items = []
    def push(self, item): 
        self.items.append(item)
    def pop(self):
        return self.items.pop()

def postfix(string, numList):
    stack = Stack()
    tmp1, tmp2 = -1, -1
    for i in string:
        if ord(i) == 43:
            tmp1 = float(stack.pop())
            tmp2 = float(stack.pop())
            stack.push(tmp2 + tmp1)
            #print(tmp2 + tmp1)
        elif ord(i) == 45:
            tmp1 = float(stack.pop())
            tmp2 = float(stack.pop())
            stack.push(tmp2 - tmp1)
            #print(tmp2 - tmp1)
        elif ord(i) == 42:
            tmp1 = float(stack.pop())
            tmp2 = float(stack.pop())
            stack.push(tmp2 * tmp1)
            #print(tmp2 * tmp1)
        elif ord(i) == 47:
            tmp1 = float(stack.pop())
            tmp2 = float(stack.pop())
            stack.push(tmp2 / tmp1)
            #print(tmp2 / tmp1)
        else:
            stack.push(numList[ord(i)-65])
            
    return stack.pop()

numCnt = sys.stdin.readline().strip()
notation = sys.stdin.readline().strip()
for cnt in range(int(numCnt)):
    num.append(sys.stdin.readline().strip())

#print(notation)
print("{:.2f}".format(postfix(notation, num)))