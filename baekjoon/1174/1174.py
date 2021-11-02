from sys import stdin


n = int(stdin.readline().rstrip())
num = [9,8,7,6,5,4,3,2,1,0]
numList = []
count = 1
def backtracking():
    for i in range(1,(1<<10)):
        sum = 0
        for j in range(10):
            if((i & (1<<j)) > 0):
                sum = sum *10 + num[j]
        numList.append(sum)
        numList.sort()
        if(n > len(numList)):
            print(-1)
            return
    print(numList[n-1])


if int(n) == 1:
    print(0)
else:
    backtracking()