def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

def solution(numbers):
    sum = 0
    for i in range(1,len(numbers[:-1])):
        for j in numbers[i+1:]:
            sum +=  gcd(numbers[i],j)
    print(sum)

t = int(input())

for _ in range(t):
    numbers = list(map(int, input().split()))
    solution(numbers)