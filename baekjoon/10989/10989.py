from sys import stdin
from collections import deque

N = int(stdin.readline())

nums = [deque() for _ in range(10)]
input_nums = []

max = 0
current = 10

for i in range(N):
    num = int(stdin.readline())
    input_nums.append(num)
    if num > max: 
        max = num
    nums[num % 10].append(num)

dq = deque(input_nums)

while max >= current:

    while dq:
        n = dq.popleft()

        nums[( n // current ) % 10].append(n)
    
    for b in nums:
        while b:
            dq.append(b.popleft())
    
    current *= 10

for i in range(N):
    print(dq[N + i])


