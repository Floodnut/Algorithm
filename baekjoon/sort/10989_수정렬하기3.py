from sys import stdin

N = int(stdin.readline())

nums = [0 for _ in range(10001)]

for n in range(N):
    nums[int(stdin.readline())-1] += 1

for n in range(len(nums)):
    for i in range(nums[n-1]):
        print(n)