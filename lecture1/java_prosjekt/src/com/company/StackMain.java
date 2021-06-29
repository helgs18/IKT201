package com.company;
class SNode {
    private String value;

    private SNode sNodeBelow;

    public SNode(String value){
        this.value = value;
    }

    public void setsNodeBelow(SNode n){
        this.sNodeBelow = n;
    }

    public String getValue(){
        return value;
    }

    public SNode getsNodeBelow(){
        return this.sNodeBelow;
    }
}

class StackClass{
    private SNode top;
    int size = 0;
    int maxSize;

    public StackClass(int maxSize){
        this.maxSize = maxSize;
    }

    public void addNewNode(SNode newSNode){
        if(size > maxSize){
            return;
        } else {
            newSNode.setsNodeBelow(top);
            this.top = newSNode;
            size++;
        }
    }

    public SNode getTop(){
        return this.top;
    }

}

public class StackMain {

    public static void main(String[] args) {
	    SNode n1 = new SNode("A");
	    SNode n2 = new SNode("B");
	    StackClass s = new StackClass(5);
	    s.addNewNode(n1);
	    s.addNewNode(n2);

        System.out.println(s.getTop().getValue());
        System.out.println(s.getTop().getsNodeBelow().getValue());
    }
}
