#complete

def solution(number, k):
    answer = []
    for i in list(number):
        while answer and answer[-1] < i and k > 0:
            answer.pop()
            k -= 1
        answer.append(i)
    
    answer = answer[:len(number) - k]
    
    return "".join(answer)
        

a = "1924"
aa = 2
b = "1231234"
bb = 3
c = "4177252841"
cc = 4

print("====================")
print("[+] a : " + str(solution(a, aa)))
print("--------------------")
print("[+] b : " + str(solution(b, bb)))
print("--------------------")
print("[+] b : " + str(solution(c, cc)))