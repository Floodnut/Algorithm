import sys

nput = True
done = True
count = 0

def treeCheck(tree):
    nput = True
    global done
    while nput:
        tc = input().rstrip().split("  ")
        #print(tc)
        if tc[0] == '' :
            continue
        for tmp in tc :
            a, b = map(int , tmp.split())
            print(a)
            print(b)
            if a == 0 and b == 0 :
                nput = False
                break
            elif a < 0 and b < 0:
                done = False
                nput = False
                return -1

            if str(b) in tree :
                check = 0
                nput = False
                return check
            else:
                tree[str(b)] = 1

    return 1

while done:
    tree = {}
    count +=1
    check = 1
    tch = treeCheck(tree)
    if tch == 1:
        print("Case "+ str(count) +" is a tree.")
    elif tch == 0:
        print("Case "+ str(count) +" is not a tree.")
    
    tch = -2


