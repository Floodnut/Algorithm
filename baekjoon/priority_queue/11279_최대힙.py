import sys

n = int(sys.stdin.readline())
hArr = [0 for i in range(0, n)]
size = 0

def push(num):
    global size
    global hArr
    size += 1
    hArr[size] = num
    maxheap()

def delete():
    global size
    global hArr

    if size == 0:
        print(size)
    
    else:
        print(hArr[1])
        hArr[1] = hArr[size]
        hArr[size] = 0
        size -= 1
        parent = 1
        child = 2
        while child <= size:
            if (child + 1 <= size) and (hArr[child + 1] > hArr[child]):
                child = child + 1
            if hArr[child] > hArr[parent]:
                tmp = hArr[child]
                hArr[child] = hArr[parent]
                hArr[parent] = tmp
                parent = child
                child = parent * 2
            else:
                break


def maxheap():
    global size
    global hArr
    idx = size
    while idx > 1:
        parent = hArr[int(idx/2)]
        child = hArr[idx]
        if parent < child:
            tmp = child
            hArr[idx] = parent
            hArr[int(idx/2)] = tmp
            idx = int(idx/2) 
        else:
            break

for i in range(0, n):
    num = int(sys.stdin.readline())
    if num == 0:
        delete()
    else:
        push(num)