import heapq

def solution(scoville, K):
    answer = 0

    hq = []

    for s in scoville:
        heapq.heappush(hq, s)

    while hq[0] < K:
        try:
            a = heapq.heappop(hq)
            b = heapq.heappop(hq)
            heapq.heappush(hq, a + (b * 2))
            answer += 1
        except:
            return -1
        
    return answer


a = [1, 2, 3, 9, 10, 12]
aa = 7

print("====================\n[+] ", solution(a, aa))
