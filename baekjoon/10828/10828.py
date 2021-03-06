import sys
class Node:
	def __init__(self):
		self.tail=[]
	def len(self):
		return len(self.tail)
	def push(self,data):
		self.tail.append(data)
	def pop(self):
		if not self.tail:
			return -1
		else:
			popnum= self.tail[len(self.tail)-1]
			del self.tail[len(self.tail)-1]
			return popnum
	def empty(self):
		return self.tail
	def top(self):
		return(self.tail[len(self.tail)-1])
	def list(self):
		return self.tail
count = sys.stdin.readline().strip()
command=[]
stack = Node()
for i in range(1, int(count)+1):
	command = sys.stdin.readline().strip().split(' ')
	if command[0]=='push' :
		stack.push(int(command[1]))
	elif command[0] == 'pop':
			print(stack.pop())
	elif command[0] == 'size':
		print(stack.len())
	elif command[0] == 'empty':
		if stack.empty():
			print(0)
		else:
			print(1)
	elif command[0] =='top':
		if stack.len()==0:
			print(-1)
		else:
			print(stack.top())
