from sys import stdin
from itertools import permutations

def isPrime(num):
    if num == 1 or num == 0:
        return False

    for i in range(2, int(num ** 0.5)+1):
        if (num % i == 0) :
            return False

    return True

def solution(numbers):
    answer = 0
    pl = list()
    numli = list(numbers)

    for i in range(1, len(numbers)+1):
        per = list(permutations(numli, i))
        pl += per

    for i in range(len(pl)):
        pl[i] = int("".join(pl[i]))

    pl = list(set(pl))
    for i in pl:
        if isPrime(i):
            answer += 1


    return answer


a = "17"
aa = "011"

print("==========")
print("[+] " + str(solution(aa)))