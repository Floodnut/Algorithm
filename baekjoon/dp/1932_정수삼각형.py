from sys import stdin

def max_(a, b):
    return a if a > b else b

def solution(tri, SIZE):
    mx = 0
    for i in range(SIZE):
        for j in range(len(tri[i])):
            if i == 0 and j == 0:
                continue
            if j == 0 :
                tri[i][j] += tri[i-1][j]
                
            elif j == len(tri[i]) - 1:
                tri[i][j] += tri[i-1][j-1]
            else:
                tri[i][j] += max_(tri[i-1][j-1],tri[i-1][j])

    return max(tri[i])

SIZE = int(stdin.readline())
tri = []

for _ in range(SIZE):
    tri.append(list(map(int,stdin.readline().split())))

print(solution(tri, SIZE))
