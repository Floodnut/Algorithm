def solution(bridge_length, weight, truck_weights):
    answer = 0
    uw = 0
    going = []
    gone = []
    trucks = len(truck_weights)

    while(trucks != len(gone)):

        if len(going) > 0 : #7
            if (answer - going[0][1]) == bridge_length:
                gg = going.pop(0)
                gone.append(gg)
                uw -= gg[0]
                
        if len(truck_weights) != 0 and uw + truck_weights[0] <= weight:
            uw += truck_weights[0]
            going.append((truck_weights.pop(0), answer)) # 5

        answer += 1

    return answer

a = 2
aa = 10
aaa = [7,4,5,6]
b = 100
bb = 100
bbb = [10]
c = 100
cc = 100
ccc = [10,10,10,10,10,10,10,10,10,10]

print("==========")
print("[+] " + str(solution(a, aa, aaa)))