package com.company;

class QNode {
    private String value;
    private QNode next = null;

    public QNode(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public void setNext(QNode next){
        this.next = next;
    }

    public QNode getNext(){
        return this.next;
    }

    public void delNode(QNode node){
        node.value = null;
        node.next = null;
    }
}

class QueueClass {
    QNode head;
    private int size = 0;
    private int maxSize = 50;

    public QueueClass(int maxSize){
        this.maxSize = maxSize;
    }

    public QNode getHead(){
        return this.head;
    }

    public void setHead(QNode head){
        this.head = head;
    }

    public void increaseSize(){
        this.size++;
    }

    public void decreaseSize(){
        this.size--;
    }

    public void addNode(QNode node){
        if(this.head == null){
            this.head = node;
        } else {
            QNode back = loopToBack();
            back.setNext(node);
        }
        this.increaseSize();
    }

    public QNode loopToBack(){
        QNode tempNode = this.head;
        while(tempNode.getNext() != null)
            tempNode = tempNode.getNext();
        return tempNode;
    }

    public void removeNode(){
        QNode firstNode = this.head;
        QNode secondNode = firstNode.getNext();
        this.setHead(secondNode);
        this.decreaseSize();
        firstNode = null;
    }
}

public class QueueMain {
    public static void main(String args[]){
        QNode n1 = new QNode("A");
        QNode n2 = new QNode("B");
        QueueClass q = new QueueClass(2);
        q.addNode(new QNode("Q"));      // Vil denne bli slettet, når den settes til null
        q.addNode(n1);
        q.addNode(n2);
        System.out.println(q.getHead().getValue());
        System.out.println(q.getHead().getNext().getValue());
        q.removeNode();                     // Blir noden med value Q slettet etter dette, og hvordan kan jeg i såfall
                                            // sjekke dette?
        System.out.println(q.getHead().getValue());
    }
}
