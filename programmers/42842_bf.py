from sys import stdin

def getSize(a, b, o):
    aa = a + 2
    bb = b + 2
    if b > a:
        return [bb, aa]
    return [aa, bb]

def isPrime(num):
    for i in range(2, int(num ** 0.5)+1):
        if (num % i == 0) :
            return False
    return True

def divs(n):
    sum = list()
    for i in range(1, int(n ** 0.5)+1):
        if (n % i == 0):
            sum.append((i,int(n/i)))

    return sum

    

def solution(brown, yellow):
    answer = []
    d = []
    if isPrime(yellow):
        answer = getSize(1, yellow, brown)
    else:
        d = divs(yellow)
        # 12 -> [(1,12),(2,16)...(4,6)]
        for i in d:
            if ((i[0] + 2) * (i[1] + 2)) - (i[0] * i[1]) == brown:
                answer = getSize(i[0],i[1],brown)
                return answer
            else:
                continue
    return answer



a = 10
aa = 2
b = 8
bb = 1
c = 24
cc = 24

print("==========")
print("[+] " + str(solution(c, cc)))

