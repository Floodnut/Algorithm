a=int(input())
prt=[]
for i in range(a):
    b=input().split('\n')
    li = []
    string=''.join(b).split()
    for j in string:
        str=j[::-1]
        li.append(str)
    prt.append(li)

for i in range(a):
    print(' '.join(prt[i]))
