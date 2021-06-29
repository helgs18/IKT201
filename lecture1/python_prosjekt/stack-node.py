# stack image: https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2013/03/stack.png

class Node:
    def __init__(self, value):
        self.value = value
        self.nodeBelow = None

    # This is all you need to create a stack / Stack = LIFO (last in first out)
    # (The opposite is Queue where it is FIFO (first in first out)
    def setNodeBelow(self, nodey):
        self.nodeBelow = nodey


class StackClass:
    def __init__(self, maxSize):
        self.top = None
        self.Size = 0
        self.maxSize = maxSize

    def setTop(self, newTop):
        newTop.setNodeBelow(self.top)   # self.top is a pointer
        self.top = newTop               # set this after setNodeBelow to avoid loop

    def addNewNode(self, newNode):
        if self.Size > self.maxSize:
            return False
        else:
            self.setTop(newNode)
            self.Size += 1         # Python doesn't have ++

"""
# Dette feilet. Size blei oppdatert, men top node blei ikke lagt til. 
# Dette var før self.next og setNext() blei lagt til.
n1 = Node(4)
n2 = Node(6)
print(n1.value)
print(n1.nodeBelow)

s = StackClass(5)
s.addNewNode(n1)
s.addNewNode(n2)

print(s.Size)
"""
""" Legger til nodes og tester setNodeBelow()
n1 = Node("A")
n2 = Node("B")
n1.setNodeBelow(n2)
print(n1.value)
print(n1.nodeBelow)
print(n1.nodeBelow.value)
"""

def main():
    # Hvorfor får jeg ikke lagret noder i stack-klassen
    n1 = Node("A")
    n2 = Node("B")
    s = StackClass(5)
    s.addNewNode(n1)
    s.addNewNode(n2)
    print(s.Size)
    print(s.maxSize)


if __name__ == "__main__":
    main()