from collections import defaultdict

def solution(prices):
    answer = [0 for _ in range(len(prices))]

    
    for i in range(len(prices)):
        target = prices[i]
        
        for j in range(i+1, len(prices)):
            if prices[j] >= target:
                answer[i] += 1
            else:
                answer[i] += 1
                break
                
        
    return answer