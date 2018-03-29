private class Node{
    Node next,prev;
    int data;
    private Node getNext(){
	return next;
    }
    private Node getPrev(){
	return prev;
    }
    private int getValue(){
	return data;
    }
    private Node setNext(int i){
	next=i;
    }
    private Node setPrev(int i){
	prev=i;
    }
    private int setValue(int i){
	data=i;
    }
    private String toString(){
	return data+"";
    }
}
