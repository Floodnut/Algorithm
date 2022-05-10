def solution(participant, completion):
    hash = dict()
    
    for _p in participant:
        if _p in hash:
            hash[_p] += 1
        else:
            hash[_p] = 1
    
    for _c in completion:
        hash[_c] -= 1
    
    
    for _h in hash:
        if hash[_h] != 0:
            return _h  

'''
a = ["mislav", "stanko", "mislav", "ana"]
b = ["stanko", "ana", "mislav"]

c = ["marina", "josipa", "nikola", "vinko", "filipa"]
d = ["josipa", "filipa", "marina", "nikola"]

print("==============")
print(solution(c,d))
'''