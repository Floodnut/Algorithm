from sys import stdin

n, c = map(int, stdin.readline().split())
x = []
distance = 0

for _ in range(n): x.append(int(stdin.readline().rstrip()))
x.sort()
start = 1
end = x[n-1]

def binarySearch(mid, lst):
    global n
    idx = lst[0] 
    cnt = 1
    for i in range(1, n):
        if (lst[i] - idx) >= mid :
            cnt += 1
            idx = lst[i]

    return cnt

while(start <= end):
    mid = int((start + end) / 2)
    count = binarySearch(mid, x)
    if count >= c:
        if distance < mid: distance = mid
        start = mid + 1
    else:
        end = mid - 1
print(distance)