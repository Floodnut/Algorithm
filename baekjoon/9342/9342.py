import re, sys

regex = re.compile('[A-F]{0,1}A+F+C+[A-F]{0,1}$')
wordCounts = int(input())
words = []

for repeat in range(wordCounts):
    a = sys.stdin.readline().strip()
    words.append(a)

for isInfected in words:
    isMatch = regex.match(isInfected)
    if(isMatch != None):
        print('Infected!')
    else:
        print('Good')