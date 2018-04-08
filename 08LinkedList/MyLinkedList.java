public class MyLinkedList{
    private Node start,end;
    private int size;

    //This method will help you write other
    //methods, it is private to protect your list
    private Node getNode(int index){
	return new Node(index);
    }


    public MyLinkedList(){
	size=0;
	start=null;
        end=null;
    }
    public String toString(){
	String all="{";
	for(int i=0;i<size;i++){
	    all+=getNode(i)+ ", ";
	}
	all+="}";
	return all;
    }
    public void clear(){
	size=0;
	start=null;
	end=null;
    }
    public int size(){
	return size;
    }
    public Integer get(int index){//exceptions!
	return getNode(index).getValue();
    }
    public Integer set(int index, Integer value){//exceptions!
	getNode(index).setValue(value);
	return getNode(index).getValue();
    }

    public int indexOf(Integer value){
	for(int i=0;i<size;i++){
	    if(getNode(i).getValue()==value){
		return i;
	    }
	}
	return -1;
    }

    public boolean add(Integer newData){
	getNode(size).setValue(newData);
	size++;
	return true;
    }
    public void add(int index, Integer value){//exceptions!
	if(0<=index && index<size){
	    int current=value;
	    int next;
	    for(int i=0;i<size;i++){
		next=getNode(i).getNext().getValue();
		getNode(i).setValue(current);
		current=next;		
	    }
	    size++;
	}else
	    if(index==size){
		add(value);
	    }else{
		throw new IndexOutOfBoundsException();
	    }
    }

    //The remove methods can cause a problem, this is why we shouldn't 
    //use an int as the data, we need objects to distinguish between index and data
    public boolean remove(Integer value){
	for(int i=0;i<size;i++){
	    if(value==getNode(i).getValue()){
		int y=getNode(i).getNext().getValue();
		getNode(i).setValue(y);
		size--;
		return true;
	    }
	}
	return false;
    }
    public Integer remove(int index){//exceptions!
	int num;
	if(0<=index && index<size){
	    num=getNode(index).getValue();
	    for(int i=index;i<size;i++){
		getNode(i).setValue(getNode(i).getNext().getValue());
	    }
	    size--;
	    return num;
	}
	if(index==size){
	    num=getNode(index).getValue();
	    getNode(index).setValue(getNode(index).getNext().getValue());
	    size--;
	    return num;
	}
	throw new IndexOutOfBoundsException();
    }
    private class Node{
	Node next,prev;
	int data;

	public Node(int index){
	    //next=null;
	    // prev=null;
	}
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
	    next=new Node(i);
	    return next;
	}
	private Node setPrev(int i){
	    prev=new Node(i);
	    return prev;
	}
	private int setValue(int i){
	    data=i;
	    return data;
	}
	public String toString(){
	    return prev.getValue()+" "+data+" "+next.getValue();
	}
    }

}
