from sys import stdin

class Node:
    def __init__(self,node):
        self.info = node
        self.left = None
        self.right = None

class Tree:
    def __init__(self):
        self.root = None

    def createTree(self,treeDict,treeNode):
        treeDict[treeNode[0]] = Node(treeNode) if treeDict.get(treeNode[0]) is None else treeDict[treeNode[0]]
        treeDict[treeNode[1]] = Node(treeNode[1]) if treeNode[1] != '.' and treeDict.get(treeNode[1]) is None else None
        treeDict[treeNode[2]] = Node(treeNode[2]) if treeNode[2] != '.' and treeDict.get(treeNode[2]) is None else None

        if self.root == None:
            self.root = treeDict[treeNode[0]]

        treeDict[treeNode[0]].info = treeNode
        treeDict[treeNode[0]].left = treeDict.get(treeNode[1])
        treeDict[treeNode[0]].right = treeDict.get(treeNode[2]) 

        return treeDict

    def preOrder(self, treeNode):
        print(treeNode.info[0],end='')
        if treeNode.left is not None : 
            self.preOrder(treeNode.left)
        if treeNode.right is not None : 
            self.preOrder(treeNode.right)

    def inOrder(self, treeNode):
        if treeNode.left is not None : 
            self.inOrder(treeNode.left)
        print(treeNode.info[0],end='')
        if treeNode.right is not None : 
            self.inOrder(treeNode.right)

    def postOrder(self, treeNode):
        if treeNode.left is not None : 
            self.postOrder(treeNode.left)
        if treeNode.right is not None : 
            self.postOrder(treeNode.right)
        print(treeNode.info[0],end='')
        
    
if __name__ == "__main__":
    treeDict, bTree, n = dict(), Tree(), int(stdin.readline())

    for i in range(n):
        treeNode = stdin.readline().split()
        treeDict = bTree.createTree(treeDict,treeNode)
    del(treeDict['.'])
    
    bTree.preOrder(treeDict['A'])
    print("")
    bTree.inOrder(treeDict['A'])
    print("")
    bTree.postOrder(treeDict['A'])
    print("")
