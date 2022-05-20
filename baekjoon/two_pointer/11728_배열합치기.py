from sys import stdin

N, M = map(int, stdin.readline().split())
A = list(map(int, stdin.readline().split()))
B = list(map(int, stdin.readline().split()))

ap, bp = 0, 0

while ap < N or bp < M :
    if bp == M :
        print(A[ap],end=" ")
        ap += 1
        
    elif ap == N or B[bp] <= A[ap]:
        print(B[bp],end=" ")
        bp += 1 

    elif A[ap] < B[bp]:
        print(A[ap],end=" ")
        ap += 1
    else:
        print(B[bp],end=" ")
        bp += 1        
print()