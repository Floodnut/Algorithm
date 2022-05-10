from collections import defaultdict

def comb(d):
    result = 1
    for i in d:
        result *= (d[i] + 1)
    return result - 1


def solution(clothes):
    answer = 0
    
    cdict = defaultdict(int)
    
    for i, c in enumerate(clothes):
        cdict[c[1]] += 1
    
    answer = comb(cdict)
    
    return answer


a = [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
b = [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]

print("==========")
print("[+] " + str(solution(b)))