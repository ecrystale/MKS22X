public class MyLinkedList{
    private Node start,end;
    private int size;

    //This method will help you write other
    //methods, it is private to protect your list
    private Node getNode(int index){
	Node current=start;
	int i=0;
	while(current!=null){
	    if(i==index){
		return current;
	    }
	    current=current.getNext();
	    i++;
	}	
	return current;
        
    }


    public MyLinkedList(){
	size=0;
	start=null;
        end=null;
    }
    public String toString(){
	String all="{";
	for(int i=0;i<size;i++){
	    if(i<size-1){
		all+=getNode(i).getValue()+ ", ";
	    }else{
		all+=""+getNode(i).getValue();
	    }
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
	if(0<=index && index<size){ 
	return getNode(index).getValue();
	}
	throw new IndexOutOfBoundsException();
    }
    public Integer set(int index, Integer value){//exceptions!
	if(0<=index && index<size){ 

	    getNode(index).setValue(value);
	    return getNode(index).getValue();
	}
	throw new IndexOutOfBoundsException();

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
	if(size==0){
	    start=new Node(newData);
	    end=start;
	    size++;
	    return true;
	}
	else{
	    //getNode(size).setNext(size);
	    Node work=new Node(newData);
	    end.setNext(work);
	    work.setPrev(end);
	    end=work;
	    size++;
	    return true;
	}
    }
   public void add(int index, Integer value){//exceptions!
	int current=value;
	int next;
	//Node NN;

	if(0<=index && index<=size){ 
	    if(index==0 && size==0){
		Node NN=new Node(value);
		//NN.setValue(value);
		start=NN;
		size++;
	    }
	    if(index==0){
		Node NN=new Node(value);
		Node work=getNode(index);
		//NN.setValue(value);
		work.setPrev(NN);
		NN.setNext(work);
		start=NN;
		size++;
		//end=end.getNext();
	    }
	    else if(index==size){
		add(value);
		//Node work= new Node(size);
		//work.setValue(value);
	    }   
	    else{
		Node NN=new Node(value);
		Node work=getNode(index);
		work.getPrev().setNext(NN);
		NN.setPrev(work.getPrev());
		NN.setNext(work);
		work.setPrev(NN);
		size++;
		/**
		   for(int i=index;i<=size;i++){
		   Node work=getNode(i);
		   //	orig=work;
		   next=work.getValue();
		   NN=work;
		   work.setValue(current);
		   work.setNext(NN);
		   current=next;
		   }
		   size++;
		   }*/
	    }
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
   }

    //The remove methods can cause a problem, this is why we shouldn't 
    //use an int as the data, we need objects to distinguish between index and data
    public boolean remove(Integer value){
	boolean found=false;
        Node work=start;
	while(work!=null){
	    //getNode(size).setNext(size);
	    //Node work=getNode(i);
	    if(work.getValue()==value){
		if(work==start){
		    start=work.getNext();
		    size--;
		    return true;
		}
		if(work==end){
		    end=end.getPrev();
		    end.setNext(null);
		    size--;
		    return true;
		}
		else{
		    work.getNext().setPrev(work.getPrev());
		    work.getPrev().setNext(work.getNext());
		    size--;
		    return true;
		}
	    }
	    work=work.getNext();
	
	}
	return false;
    }

    public Integer remove(int index){//exceptions!
	int num;
	Node work;
	if(0<=index && index<size){
	    work=getNode(index);
	    num=getNode(index).getValue();
	    getNode(index).setValue(getNode(index).getValue());
	
	    if(work==start){
		start=work.getNext();
		size--;
		return num;
	    }
	    if(work==end){
		end=end.getPrev();
		end.setNext(null);
		size--;
		return num;
	    }
	    else{
		work.getNext().setPrev(work.getPrev());
		work.getPrev().setNext(work.getNext());
		size--;
		return num;
	    }
	}
	
	throw new IndexOutOfBoundsException();
    }


    
    private class Node{
	Node next,prev;
	int data;

	public Node(int index){
	    data=index;
	    //next=null;
	    //prev=null;
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
	private void setNext(Node i){
	    next=i;
	    //return next;
	}
	private void setPrev(Node n){
	    prev=n;
	    //return prev;
	}
	private int setValue(Integer i){
	    data=i;
	    return data;
	}
	public String toString(){
	    return data+" ";
	}
    }

}
