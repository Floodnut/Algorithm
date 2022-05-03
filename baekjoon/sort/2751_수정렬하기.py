from sys import stdin

N = int(stdin.readline())

nums = list()

for _ in range(N):
    nums.append(int(stdin.readline()))
nums.sort(key=lambda x:x)

for i in range(N):
    print(nums[i])