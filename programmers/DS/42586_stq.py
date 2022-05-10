def solution(progress, speed):
    answer = []
    now = 0

    today = 0
    while(now < len(progress)):
        #print("=====")
        for i in range(len(progress)):
            progress[i] += speed[i]

            #print(progress[i], speed[i])
            if progress[now] >= 100:
                #print("add!", today)
                now += 1
                if len(answer) == today:
                    answer.append(1)
                else:
                    answer[today] += 1

        if len(answer) - 1 == today:
            today += 1
                

            
    return answer
    

a = [93, 30, 55]
aa = [1, 30, 5]
b = [95, 90, 99, 99, 80, 99]
bb = [1, 1, 1, 1, 1, 1]	

print("==========")
print("[+] " + str(solution(a, aa)))