# _queue image: https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2014/02/_queue.png

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

    def setNext(self, next):
        self.next = next


class _queue:
    def __init__(self, maxSize):
        self.head = None
        self.size = 0
        self.maxSize = maxSize

    def setHead(self, node):
        self.head = node

    def addNode(self, node):
        back = self.loopToBack()
        back.setNext(node)

    def loopToBack(self):
        tempNode = self.head
        while tempNode.next != None:
            tempNode = tempNode.next
        return tempNode

    def removeNode(self):   # _queue/FIFO = remove the first node (head)
        #tempNode = self.head
        #tempNode = tempNode.next
        #self.head = tempNode
        # if you want to delete the first one
        firstNode = self.head
        secondNode = firstNode.next
        self.setHead(secondNode)
        del firstNode

def main():
    n = Node("A")
    q = _queue(5)
    q.setHead(n)
    n2 = Node("B")
    q.addNode(n2)

    print(n.value)
    print(q.head.value)
    print(q.head.next.value)

if __name__ == "__main__":
    main()