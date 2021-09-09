import sys

wordCounts = int(input())
groupcount = 0
words = []
wordsLastPos = {}
def cmpPosition(words):
    for i in range(len(words)):
        if((wordsLastPos.get(words[i]) == None) or ((i-wordsLastPos[words[i]]) == 1) ):
            wordsLastPos[words[i]] = i
        elif( (i - wordsLastPos[words[i]]) > 1 ):
            return 0           
    return 1

for repeat in range(wordCounts):
    a = sys.stdin.readline().strip()
    words.append(a)

for repeat in words:
    if(cmpPosition(repeat) == 1):
        groupcount += 1
    wordsLastPos = {}

print(groupcount)