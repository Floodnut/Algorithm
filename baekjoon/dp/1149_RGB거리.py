from sys import stdin

def min_(a, b):
    return a if a < b else b

def solution(N, house):
    for i in range(N):

        if i == N-1 :
            return min(house[i])

        house[i+1][0] = min_(house[i][1] + house[i+1][0], house[i][2] + house[i+1][0])  #R

        house[i+1][1] = min_(house[i][0] + house[i+1][1],house[i][2] + house[i+1][1])  #G

        house[i+1][2] = min_(house[i][0] + house[i+1][2],house[i][1] + house[i+1][2])  #B

N = int(stdin.readline())
house = []
for _ in range(N):
    house.append(list(map(int, stdin.readline().split())))

print(solution(N, house))