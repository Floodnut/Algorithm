from sys import stdin

N = int(stdin.readline())
num = list(stdin.readline().strip())
k = 0
for i in num:
    k += int(i)
print(k)